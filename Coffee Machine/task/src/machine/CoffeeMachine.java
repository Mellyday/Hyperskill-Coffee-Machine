package machine;

import java.util.Scanner;

public class CoffeeMachine {
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
        int cups = Integer.parseInt(scan.nextLine());

        canMake(cups, water, milk, coffeeBeans);
    }

    @SuppressWarnings("ConstantConditions")
    public static void canMake(int cups, int water, int milk, int coffeeBeans) {
        final int waterPerCup = 200, milkPerCup = 50, coffeeBeansPerCup = 15;

        int maxCupsLimitedByWater = water / waterPerCup;
        int maxCupsLimitedByMilk = milk / milkPerCup;
        int maxCupsLimitedByCoffeeBeans = coffeeBeans / coffeeBeansPerCup;
        int maxCups = Math.min(maxCupsLimitedByWater, Math.min(maxCupsLimitedByMilk,
                maxCupsLimitedByCoffeeBeans));

        if (cups == maxCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > maxCups) {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        } else if (cups < maxCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " +
                    (maxCups - cups) + " more than that)");
        }
    }
}
