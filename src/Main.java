import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> stock = setBase();

        label:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    try {
                        int typeOfCoffee = buyCoffee();
                        stock = updateStock(typeOfCoffee, stock);
                        break;
                    } catch (Exception e) {
                        continue;
                    }
                case "fill":
                    updateStock(stock);
                    break;
                case "take":
                    withdrawMoney(stock);
                    break;
                case "remaining":
                    printStock(stock);
                    break;
                default:
                    break label;
            }
        }


    }

    public static ArrayList setBase() {
        ArrayList<Integer> stock = new ArrayList<>();
        stock.add(400);
        stock.add(540);
        stock.add(120);
        stock.add(9);
        stock.add(550);
        return stock;
    }


    //Overloading update stock method
    public static ArrayList updateStock(ArrayList stock) {
        Scanner scanner = new Scanner(System.in);
        int water = (int) stock.get(0);
        int milk = (int) stock.get(1);
        int coffeeBeans = (int) stock.get(2);
        int disposableCups = (int) stock.get(3);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
        stock.set(0, water);
        stock.set(1, milk);
        stock.set(2, coffeeBeans);
        stock.set(3, disposableCups);

        return stock;

    }

    public static ArrayList updateStock(int typeOfCoffee, ArrayList stock) {
        int water = (int) stock.get(0);
        int milk = (int) stock.get(1);
        int coffeeBeans = (int) stock.get(2);
        int disposableCups = (int) stock.get(3);
        int money = (int) stock.get(4);
        switch (typeOfCoffee) {
            case 1:
                if (sufficientStock(stock, typeOfCoffee)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    break;
                }
            case 2:
                if (sufficientStock(stock, typeOfCoffee)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                    break;
                }
            case 3:
                if (sufficientStock(stock, typeOfCoffee)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                    break;
                }
        }
        stock.set(0, water);
        stock.set(1, milk);
        stock.set(2, coffeeBeans);
        stock.set(3, disposableCups);
        stock.set(4, money);
        return stock;

    }

    public static ArrayList withdrawMoney(ArrayList stock) {
        int money = (int) stock.get(4);
        System.out.println("I gave you $" + money);
        stock.set(4, 0);
        return stock;
    }

    public static void printStock(ArrayList stock) {
        System.out.println("The coffee machine has: ");
        int water = (int) stock.get(0);
        int milk = (int) stock.get(1);
        int coffeeBeans = (int) stock.get(2);
        int disposableCups = (int) stock.get(3);
        int money = (int) stock.get(4);
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();

    }

    public static int buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        int choice = scanner.nextInt();
        return choice;
    }

    //Espresso 250ml water, 16g beans, 1 disposable, +$4
    //Latte 350ml water, 75ml milk, 20g beans, +$7
    //Cappuccino 200ml water, 100ml milk, 12g beans, +$6

    public static boolean sufficientStock(ArrayList stock, int typeOfCoffee) {
        int water = (int) stock.get(0);
        int milk = (int) stock.get(1);
        int coffeeBeans = (int) stock.get(2);
        int disposableCups = (int) stock.get(3);
        if (typeOfCoffee == 1 && water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else if (typeOfCoffee == 2 && water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else if (typeOfCoffee == 3 && water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            ArrayList<Boolean> stockChecks = new ArrayList<>();
            switch (typeOfCoffee) {
                case 1:
                    stockChecks.add(water >= 200);
                    stockChecks.add(coffeeBeans >= 16);
                    stockChecks.add(disposableCups > 1);
                    break;
                case 2:
                    stockChecks.add(water >= 350);
                    stockChecks.add(milk >= 75);
                    stockChecks.add(coffeeBeans >= 20);
                    stockChecks.add(disposableCups >= 1);
                    break;
                case 3:
                    stockChecks.add(water >= 200);
                    stockChecks.add(milk >= 100);
                    stockChecks.add(coffeeBeans >= 12);
                    stockChecks.add(disposableCups >= 1);
                    break;
            }

            ArrayList<String> missingIngredient1 = new ArrayList<>();
            missingIngredient1.add("water");
            missingIngredient1.add("coffee beans");
            missingIngredient1.add("disposable cups");
            ArrayList<String> missingIngredient2 = new ArrayList<>();
            missingIngredient2.add("water");
            missingIngredient2.add("milk");
            missingIngredient2.add("coffee beans");
            missingIngredient2.add("disposable cups");
            String missing = typeOfCoffee == 1 ?
                    missingIngredient1.get(stockChecks.indexOf(false)) :
                    missingIngredient2.get(stockChecks.indexOf(false));
            System.out.println("Sorry, not enough " + missing + "!");
            return false;

        }
    }
}
