package tdd.mission.vendingMachine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdd.mission.vendingMachine.model.Coin;
import tdd.mission.vendingMachine.model.InputAmountReqDTO;
import tdd.mission.vendingMachine.repository.CoinEntity;
import tdd.mission.vendingMachine.repository.CoinRepository;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class VendingMachineService {

    private final CoinRepository coinRepository;

    @Transactional
    public InputAmountReqDTO randomCoinByInputAmount(int inputAmount) {
        InputAmountReqDTO result = new InputAmountReqDTO();
        int remainingAmount = inputAmount;

        while (remainingAmount > 0) {
            Coin[] coins = Coin.values();
            Coin coin = coins[new Random().nextInt(coins.length)];
            int coinValue = coin.getAmount();
            if (remainingAmount >= coinValue) {
                result.addCoin(coin);
                remainingAmount -= coinValue;

                CoinEntity coinEntity = coinRepository.findByCoinType(coin);
                if (coinEntity != null) {
                    coinEntity.setCount(coinEntity.getCount() + 1);
                } else {
                    coinEntity = new CoinEntity();
                    coinEntity.setCoinType(coin);
                    coinEntity.setCount(1);
                }
                coinRepository.save(coinEntity);
            }
        }

        return result;
    }
}
