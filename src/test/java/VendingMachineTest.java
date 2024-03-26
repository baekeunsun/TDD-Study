import org.junit.jupiter.api.Test;
import tdd.mission.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    void generateRandomCoin_ShouldReturnRandomCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        int coin = vendingMachine.generateRandomCoin();
        assertTrue(coin == 10 || coin == 50 || coin == 100 || coin == 500 || coin == 1000);
    }
}