package com.example.auction.bidding.impl;

import com.google.inject.AbstractModule;
import play.Configuration;
import play.Environment;

public class FailingModule extends AbstractModule {

    private final Environment environment;
    private final Configuration configuration;

    public FailingModule(Environment environment, Configuration configuration) {
        this.environment = environment;
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        if (configuration.underlying().getBoolean("kill")) {
            throw new RuntimeException("CRASH!");
        }
    }
}
