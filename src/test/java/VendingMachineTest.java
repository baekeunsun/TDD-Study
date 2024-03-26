import org.junit.jupiter.api.Test;
import tdd.mission.Coin;
import tdd.mission.VendingMachine;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    void 랜덤으로_생성된_동전의_합이_입력값과_같은지_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        int amount = 450;
        Map<Coin, Integer> coinMap = vendingMachine.generateCoins(amount);

        assertNotNull(coinMap);

        int totalAmount = 0;
        for (Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
            Coin coin = entry.getKey();
            int numCoins = entry.getValue();
            totalAmount += coin.getAmount() * numCoins;
        }

        assertEquals(amount, totalAmount);
    }
}