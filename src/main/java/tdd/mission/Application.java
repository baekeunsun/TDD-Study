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

        System.out.println("상품명과 가격, 수량을 입력해 주세요. (예: [콜라,1500,20];[사이다,1000,10])");
        scanner.nextLine(); // 버퍼 비우기
        String productInput = scanner.nextLine();

        registerProductsFromInput(vendingMachine, productInput);

        System.out.println("자판기가 보유한 상품");
        for (Product product : vendingMachine.getProducts()) {
            System.out.println("상품명: " + product.getName() + ", 가격: " + product.getPrice() + "원, 수량: " + product.getQuantity());
        }
    }

    private static void registerProductsFromInput(VendingMachine vendingMachine, String input) {
        String[] productsInfo = input.split(";");
        for (String productInfo : productsInfo) {
            productInfo = productInfo.substring(1, productInfo.length() - 1);
            String[] info = productInfo.split(",");
            String name = info[0];
            int price = Integer.parseInt(info[1]);
            int quantity = Integer.parseInt(info[2]);
            Product product = new Product(name, price, quantity);
            vendingMachine.addProduct(product);
        }
    }

}
