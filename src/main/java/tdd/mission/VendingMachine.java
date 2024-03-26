package tdd.mission;

import java.util.Random;

public class VendingMachine {

    public int generateRandomCoin() {
        int[] coins = {10, 50, 100, 500, 1000};
        Random random = new Random();
        int index = random.nextInt(coins.length);
        return coins[index];
    }
}
