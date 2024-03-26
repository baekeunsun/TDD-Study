import org.junit.jupiter.api.Test;
import tdd.mission.Coin;
import tdd.mission.Product;
import tdd.mission.VendingMachine;

import java.util.List;
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

    @Test
    void 자판기에_상품정보가_저장되는지_확인() {
        VendingMachine vendingMachine = new VendingMachine();
        Product product1 = new Product("콜라", 1500, 20);
        Product product2 = new Product("사이다", 1000, 10);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);

        List<Product> products = vendingMachine.getProducts();

        assertEquals(2, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }
}