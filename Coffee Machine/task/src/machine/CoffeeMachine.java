package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water, milk, coffeeBeans, disposableCups, money;
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
            disposableCups--;
            money += 4;
        } else if (coffeeType == 2) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups--;
            money += 7;
        } else if (coffeeType == 3) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
            money += 6;
        }
        System.out.println();
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
        System.out.println();
    }

    public void take() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine myCoffeeMachine = new CoffeeMachine();

        myCoffeeMachine.print();
        System.out.println("Write action (buy, fill, take)");
        String action = scan.nextLine();

        switch (action) {
            case "buy":
                myCoffeeMachine.buy();
                break;
            case "fill":
                myCoffeeMachine.fill();
                break;
            case "take":
                myCoffeeMachine.take();
                break;
        }

        myCoffeeMachine.print();
    }
}
