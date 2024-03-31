package tdd.mission.vendingMachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdd.mission.vendingMachine.model.Coin;

public interface CoinRepository extends JpaRepository<CoinEntity, Long> {
    CoinEntity findByCoinType(Coin coinType);
}
