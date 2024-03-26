package tdd.mission;

import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        int inputAmount = scanner.nextInt();

        VendingMachine vendingMachine = new VendingMachine();
        Map<Coin, Integer> coinMap = vendingMachine.generateCoins(inputAmount);

        System.out.println("자판기가 보유한 동전");
        for (Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
            System.out.println(entry.getKey().getAmount() + "원 - " + entry.getValue() + "개");
        }
    }

}
