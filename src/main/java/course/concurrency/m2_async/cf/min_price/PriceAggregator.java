package course.concurrency.m2_async.cf.min_price;

import java.util.Collection;
import java.util.Set;

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
        // place for your code
        // 1. create a collection of CompletableFuture<Double>
        // 2. for each shopId create CompletableFuture<Double> and add it to the collection
        // 3. use CompletableFuture.allOf() to wait for all futures to complete
        // 4. use CompletableFuture.join() to get the result of each future
        // 5. find the minimum price
        // 6. return the minimum price
        //
        // Note: you can use the following code to retrieve the price from the shop
        // CompletableFuture<Double> future = priceRetriever.retrievePrice(shopId, itemId);
        // Double price = future.join();
        // Note: you can use the following code to find the minimum price
        // double minPrice = prices.stream().min(Double::compare).get();
        // Note: you can use the following code to convert a collection of CompletableFuture<Double> to CompletableFuture<Void>
        // CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        // Note: you can use the following code to wait for all futures to complete
        // allFutures.join();

        return 0;
    }
}
