package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water;
    int milk;
    int coffeeBeans;
    int disposableCups;
    int money;
    Scanner scan;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
        scan = new Scanner(System.in);
    }

    public void print() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeType = Integer.parseInt(scan.nextLine());
        if (coffeeType == 1) {
            water -= 250;
            coffeeBeans -= 16;
            money += 4;
        } else if (coffeeType == 2) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
        } else if (coffeeType == 3) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add");
        int input = Integer.parseInt(scan.nextLine());
        water += input;
        System.out.println("Write how many ml of milk do you want to add");
        input = Integer.parseInt(scan.nextLine());
        milk += input;
        System.out.println("Write how many grams of coffee beans do you want to add");
        input = Integer.parseInt(scan.nextLine());
        coffeeBeans += input;
        System.out.println("Write how many disposable cups of coffee do you want to add");
        input = Integer.parseInt(scan.nextLine());
        disposableCups += input;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine myCoffeeMachine = new CoffeeMachine();

        myCoffeeMachine.print();
        System.out.println("Write action (buy, fill, take)");
        String action = scan.nextLine();

        if (action.equals("buy")) {
            myCoffeeMachine.buy();
        } else if (action.equals("fill")) {
            myCoffeeMachine.fill();
        }

        myCoffeeMachine.print();
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

    /*
    System.out.println("Write how many ml of water the coffee machine has:");
        int water = Integer.parseInt(scan.nextLine());
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = Integer.parseInt(scan.nextLine());
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = Integer.parseInt(scan.nextLine());
        System.out.println("Write how many cups of coffee you will need:");
        int cups = Integer.parseInt(scan.nextLine());
     */
}
