/**
 * Final Project - tests all different codes made
 * Author: Allen Rodriguez
 * Date: May 2, 2023
 */
import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) {
    testMenu();
    }

    public static void testMenu() {
        Menu mainMenu = new Menu();
        mainMenu.addOption("Magic 8-Ball");
        mainMenu.addOption("Counter");
        mainMenu.addOption("CashRegister");
        mainMenu.addOption("BankAccount");
        mainMenu.addOption("DiceGame");
        mainMenu.addOption("Exit");

        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Select an option:");
            option = mainMenu.getInput();
            System.out.println("Input: " + option);

            switch (option) {
                case 1 -> testMagic8Ball();
                case 2 -> testCounter();
                case 3 -> testCashRegister();
                case 4 -> testBankAccount();
                case 5 -> testDiceGame();
                case 6 -> System.out.println("Thank you, goodbye!");
                default -> System.out.println("Invalid option, please try again.");
            }
        }
        while (option != 6);
    }

    public static void testMagic8Ball() {
        Scanner scanner = new Scanner(System.in);
        Magic8Ball magic8Ball = new Magic8Ball();
        boolean askAgain = true;
        while (askAgain) {
            System.out.println("Ask the Magic 8 Ball a question:");
            String question = scanner.nextLine();
            String answer = magic8Ball.ask8Ball(question);

            System.out.println("Question: " + question);
            System.out.println("Answer: " + answer + "\n");

            System.out.println("Would you like to ask another question? (Type:Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                askAgain = false;
            }
        }
    }

    public static void testCounter() {
        Counter tally = new Counter();
        tally.count();
        tally.count();
        int result = tally.getValue();
        System.out.println("Value: " + result);
        tally.count();
        tally.count();
        result = tally.getValue();
        System.out.println("Value: " + result + "\n");
    }

    public static void testCashRegister() {
        CashRegister register = new CashRegister();
        register.addItem(3.95);
        register.addItem(19.95);
        System.out.println(register.getCount());
        System.out.println("Expected: 2");
        System.out.printf("%.2f%n", register.getTotal());
        System.out.println("Expected: 23.90" + "\n");
    }

    public static void testBankAccount() {
        BankAccount allensAccount = new BankAccount(1000);
        allensAccount.deposit(500);
        allensAccount.withdraw(2000);
        allensAccount.addInterest(1);
        System.out.printf("%.2f%n", allensAccount.getBalance());
        System.out.println("Expected: 1504.90");
    }

    public static void testDiceGame() {
        DiceGame myD = new DiceGame();
        int r;
        for (int i = 0; i < 50; i++) {
            myD.roll();
        }
        System.out.println("Roll history: " + myD.getHistory());
        System.out.println("Probability of 7: " + myD.getProbability(7));
    }
}

