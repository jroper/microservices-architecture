package com.example.auction.bidding.impl;

import akka.actor.ActorSystem;
import akka.util.ByteString;
import play.Configuration;
import play.libs.streams.Accumulator;
import play.mvc.EssentialAction;
import play.mvc.EssentialFilter;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Inserts a delay to every request to simulate the bidding service being under heavy load
 */
public class DelayFilter extends EssentialFilter {

    private final boolean enabled;
    private final FiniteDuration responseDelay;
    private final ActorSystem actorSystem;

    @Inject
    public DelayFilter(ActorSystem actorSystem, Configuration configuration) {
        this.responseDelay = Duration.create(
                configuration.underlying().getDuration("insert-delay", TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
        this.actorSystem = actorSystem;

        enabled = responseDelay.toMillis() > 0;
    }

    @Override
    public EssentialAction apply(EssentialAction next) {
        if (enabled) {
            return new EssentialAction() {
                @Override
                public Accumulator<ByteString, Result> apply(Http.RequestHeader requestHeader) {
                    return next.apply(requestHeader).mapFuture(result -> {
                        CompletableFuture<Result> delayedPromise = new CompletableFuture<Result>();

                        actorSystem.scheduler().scheduleOnce(responseDelay,
                                () -> delayedPromise.complete(result), actorSystem.dispatcher());

                        return delayedPromise;
                    }, actorSystem.dispatcher());
                }
            };
        } else {
            return next;
        }
    }
}
