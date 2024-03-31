package tdd.mission.vendingMachine.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tdd.mission.vendingMachine.model.Coin;

@Entity
@Table(name = "coin")
@Getter @Setter
public class CoinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "coin_type")
    private Coin coinType;

    @Column(name = "count")
    private int count;
}
