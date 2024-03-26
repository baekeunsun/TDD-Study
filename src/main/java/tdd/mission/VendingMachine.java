package tdd.mission;

import java.util.*;

public class VendingMachine {
    private List<Product> products;

    public Map<Coin, Integer> generateCoins(int amount) {
        Map<Coin, Integer> coinMap = new HashMap<>();
        int remainingAmount = amount;

        while (remainingAmount > 0) {
            Coin[] coins = Coin.values();
            Coin coin = coins[new Random().nextInt(coins.length)];
            int coinValue = coin.getAmount();
            if (remainingAmount >= coinValue) {
                int numCoins = remainingAmount / coinValue;
                coinMap.put(coin, numCoins);
                remainingAmount %= coinValue;
            }
        }

        return coinMap;
    }

    public VendingMachine() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
