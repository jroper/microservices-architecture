import com.example.auction.bidding.impl.DelayFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

import javax.inject.Inject;

public class Filters implements HttpFilters {

    private final DelayFilter delayFilter;

    @Inject
    public Filters(DelayFilter delayFilter) {
        this.delayFilter = delayFilter;
    }

    @Override
    public EssentialFilter[] filters() {
        return new EssentialFilter[] {delayFilter};
    }
}
