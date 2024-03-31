package tdd.mission.vendingMachine.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class InputAmountReqDTO {
    private Map<Coin, Integer> coinCounts;

    public InputAmountReqDTO() {
        this.coinCounts = new HashMap<>();
    }

    public void addCoin(Coin coin) {
        coinCounts.put(coin, coinCounts.getOrDefault(coin, 0) + 1);
    }

    public Map<Coin, Integer> getCoinCounts() {
        return coinCounts;
    }
}
