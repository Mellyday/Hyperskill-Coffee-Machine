package machine;

import java.util.Scanner;

public class CoffeeMachine {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = Integer.parseInt(scan.nextLine());
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = Integer.parseInt(scan.nextLine());
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = Integer.parseInt(scan.nextLine());

        System.out.println("Write how many cups of coffee you will need:");
        int cupsRequested = Integer.parseInt(scan.nextLine());

        int maxCupsLimitedByWater = water / 200;
        int maxCupsLimitedByMilk = milk / 50;
        int maxCupsLimitedByCoffeeBeans = coffeeBeans / 15;
        int maxCups = Math.min(maxCupsLimitedByWater, Math.min(maxCupsLimitedByMilk,
                maxCupsLimitedByCoffeeBeans));

        if (cupsRequested == maxCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsRequested > maxCups) {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        } else if (cupsRequested < maxCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " +
                    (maxCups - cupsRequested) + " more than that)");
        }
    }
}
