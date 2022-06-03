import java.util.ArrayList;
import java.util.Scanner;

public class Coffee {
    int water, milk, coffeeBeans, disposableCups, money;

    public Coffee() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public boolean run(String choice) {
        Scanner scanner = new Scanner(System.in);
        boolean keepLooping = true;
        switch (choice) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                try {
                    int typeOfCoffee = scanner.nextInt();
                    updateStock(typeOfCoffee);
                    break;
                } catch (Exception e) {
                    return false;
                }
            case "fill":
                updateStock();
                break;
            case "take":
                withdrawMoney();
                break;
            case "remaining":
                printStock();
                break;
        }
        return keepLooping;
    }

    public void printStock() {
        System.out.println("The coffee machine has: ");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " g of coffee beans");
        System.out.println(this.disposableCups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    public void updateStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += scanner.nextInt();
    }

    public void updateStock(int typeOfCoffee) {
        switch (typeOfCoffee) {
            case 1:
                if (sufficientStock(typeOfCoffee)) {
                    this.water -= 250;
                    this.coffeeBeans -= 16;
                    this.disposableCups -= 1;
                    this.money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
                break;
            case 2:
                if (sufficientStock(typeOfCoffee)) {
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    this.disposableCups -= 1;
                    this.money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
                break;
            case 3:
                if (sufficientStock(typeOfCoffee)) {
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    this.disposableCups -= 1;
                    this.money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
                break;
        }
    }

    public boolean sufficientStock(int typeOfCoffee) {
        boolean isSufficient = false;
        switch (typeOfCoffee) {
            case 1:
                isSufficient = this.water >= 250 && this.coffeeBeans >= 16 && this.disposableCups >= 1 ? true : false;
                if (!isSufficient) findMissing(typeOfCoffee);
                break;
            case 2:
                isSufficient = this.water >= 350 && this.milk >= 75 && this.coffeeBeans >= 20 && this.disposableCups >= 1 ? true : false;
                if (!isSufficient) findMissing(typeOfCoffee);
                break;
            case 3:
                isSufficient = this.water >= 200 && this.milk >= 100 && this.coffeeBeans >= 12 && this.disposableCups >= 1 ? true : false;
                if (!isSufficient) findMissing(typeOfCoffee);
                break;
        }
        return isSufficient;
    }

    public void findMissing(int typeOfCoffee) {
        ArrayList<Boolean> missingItem = new ArrayList<>();
        ArrayList<String> espressoItems = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();
        String missing = "";
        espressoItems.add("water");
        espressoItems.add("coffee beans");
        espressoItems.add("disposable cups");
        items.add("water");
        items.add("milk");
        items.add("coffee beans");
        items.add("disposable cups");
        switch (typeOfCoffee) {
            case 1:
                missingItem.add(this.water >= 250);
                missingItem.add(this.coffeeBeans >= 16);
                missingItem.add(this.disposableCups >= 1);
                missing = espressoItems.get(missingItem.indexOf(false));
                System.out.println("Sorry, not enough " + missing + "!");
                break;
            case 2:
                missingItem.add(this.water >= 350);
                missingItem.add(this.milk >= 75);
                missingItem.add(this.coffeeBeans >= 20);
                missingItem.add(this.disposableCups >= 1);
                missing = items.get(missingItem.indexOf(false));
                System.out.println("Sorry, not enough " + missing + "!");
                break;
            case 3:
                missingItem.add(this.water >= 200);
                missingItem.add(this.milk >= 100);
                missingItem.add(this.coffeeBeans >= 16);
                missingItem.add(this.disposableCups >= 1);
                System.out.println("Sorry, not enough " + missing + "!");
                break;
        }
    }

    public void withdrawMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }
}