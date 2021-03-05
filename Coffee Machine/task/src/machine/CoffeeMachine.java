package machine;

import java.util.Scanner;

public class CoffeeMachine {
    enum State { RUNNING, CHOOSE_COFFEE, FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS }
    int water, milk, coffeeBeans, disposableCups, money;
    Scanner scan;
    State state = State.RUNNING;

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

    public void makeCoffee(String action) {
        if ("back".equals(action)) {
            state = State.RUNNING;
            return;
        }

        int coffeeType = Integer.parseInt(action);

        if (coffeeType == 1) {
            processBuy(250, 0, 16, 4);
        } else if (coffeeType == 2) {
            processBuy(350, 75, 20, 7);
        } else if (coffeeType == 3) {
            processBuy(200, 100, 12, 6);
        }
    }

    private void processBuy(int water, int milk, int coffeeBeans, int money) {
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
            state = State.RUNNING;
            return;
        }
        if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
            state = State.RUNNING;
            return;
        }
        if (this.coffeeBeans < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            state = State.RUNNING;
            return;
        }
        if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            state = State.RUNNING;
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        this.disposableCups -= 1;
        this.water -= water;
        this.milk -= milk;
        this.coffeeBeans -= coffeeBeans;
        this.money += money;
        state = State.RUNNING;
    }

    public void fillWater(String arg) {
        System.out.println("Write how many ml of water do you want to add");
        int input = Integer.parseInt(arg);
        water += input;
        state = State.FILL_MILK;
    }

    public void fillMilk(String arg) {
        System.out.println("Write how many ml of milk do you want to add");
        int input = Integer.parseInt(arg);
        milk += input;
        state = State.FILL_BEANS;
    }

    public void fillBeans(String arg) {
        System.out.println("Write how many grams of coffee beans do you want to add");
        int input = Integer.parseInt(arg);
        coffeeBeans += input;
        state = State.FILL_CUPS;
    }

    public void fillCups(String arg) {
        System.out.println("Write how many disposable cups of coffee do you want to add");
        int input = Integer.parseInt(arg);
        disposableCups += input;
        System.out.println();
        state = State.RUNNING;
    }

    public void take() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = 0;
    }

    public void chooseAction(String arg) {
        if ("buy".equals(arg)) {
            state = State.CHOOSE_COFFEE;
        } else if ("fill".equals(arg)) {
            state = State.FILL_WATER;
        }
        if ("remaining".equals(arg)) {
            print();
        }
        if ("take".equals(arg)) {
            take();
        }
    }

    public void prompt() {
        switch (state) {
            case RUNNING:
                System.out.println("Write action (buy, fill, remaining, take, exit)");
                break;
            case CHOOSE_COFFEE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                break;
            case FILL_WATER:
                System.out.println("Write how many ml of water do you want to add");
                break;
            case FILL_MILK:
                System.out.println("Write how many ml of milk do you want to add");
                break;
            case FILL_BEANS:
                System.out.println("Write how many grams of coffee beans do you want to add");
                break;
            case FILL_CUPS:
                System.out.println("Write how many disposable cups of coffee do you want to add");
                break;
        }
    }
    
    public void processRequest(String arg) {
        switch (state) {
            case RUNNING:
                chooseAction(arg);
                break;
            case CHOOSE_COFFEE:
                makeCoffee(arg);
                break;
            case FILL_WATER:
                fillWater(arg);
                break;
            case FILL_MILK:
                fillMilk(arg);
                break;
            case FILL_BEANS:
                fillBeans(arg);
                break;
            case FILL_CUPS:
                fillCups(arg);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine myCoffeeMachine = new CoffeeMachine();

        while (true) {
            myCoffeeMachine.prompt();

            String action = scan.nextLine();
            if ("exit".equals(action)) {
                break;
            }
            myCoffeeMachine.processRequest(action);
        }
    }
}
