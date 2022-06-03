import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coffee coffeeMachine = new Coffee();
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            boolean returned = coffeeMachine.run(choice);
            if (choice.equals("exit")) break;
            if (!returned) continue;
        }
    }
}