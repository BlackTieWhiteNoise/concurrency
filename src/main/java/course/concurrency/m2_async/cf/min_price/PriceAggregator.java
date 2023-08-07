package course.concurrency.m2_async.cf.min_price;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class PriceAggregator {

    private PriceRetriever priceRetriever = new PriceRetriever();

    public void setPriceRetriever(PriceRetriever priceRetriever) {
        this.priceRetriever = priceRetriever;
    }

    private Collection<Long> shopIds = Set.of(10l, 45l, 66l, 345l, 234l, 333l, 67l, 123l, 768l);

    public void setShops(Collection<Long> shopIds) {
        this.shopIds = shopIds;
    }

    public double getMinPrice(long itemId) {
        ExecutorService executor = Executors.newCachedThreadPool();

        return shopIds.stream()
                .map(shopId -> CompletableFuture.supplyAsync(
                                () -> priceRetriever.getPrice(shopId, itemId),
                                executor
                        ).completeOnTimeout(Double.NaN, 2950, TimeUnit.MILLISECONDS)
                        .exceptionally(exception -> Double.NaN))
                .collect(toList())
                .stream()
                .mapToDouble(CompletableFuture::join)
                .filter(price -> !Double.isNaN(price))
                .min()
                .orElse(Double.NaN);
    }
}
