import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tdd.mission.vendingMachine.model.Coin;
import tdd.mission.vendingMachine.model.InputAmountReqDTO;
import tdd.mission.vendingMachine.repository.CoinEntity;
import tdd.mission.vendingMachine.repository.CoinRepository;
import tdd.mission.vendingMachine.service.VendingMachineService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class VendingMachineTest {
    @Mock
    private CoinRepository coinRepository;

    @InjectMocks
    private VendingMachineService vendingMachineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void randomCoinByInputAmount_Should_Return_Correct_Sum() {
        // Given
        int inputAmount = 1000;

        // When
        InputAmountReqDTO inputAmountReqDTO =  vendingMachineService.randomCoinByInputAmount(inputAmount);

        // Then
        int sum = sumAllCoins(inputAmountReqDTO);
        assertEquals(inputAmount, sum);
    }

    // 저장된 동전 정보의 합계를 계산하는 메서드
    private int sumAllCoins(InputAmountReqDTO inputAmountReqDTO) {
        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : inputAmountReqDTO.getCoinCounts().entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            sum += coin.getAmount() * count;
        }
        return sum;
    }

}