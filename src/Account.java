import java.util.Scanner;
public class Account {
    // class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // class constructor
    Account(String custName, String custID){
        customerName = custName;
        customerID = custID;
    }

    // function to deposit money
    void deposit(int amount) {
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // function for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // function for showing previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occured");
        }
    }

    // menu function
    void showMenu () {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println(" What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
            // Case A allows the user to check their balance
                case 'A':
                    System.out.println("==================");
                    System.out.println("Balance = £" + balance);
                    System.out.println("==================");
                    System.out.println();
                    break;
            // Case B allows the user to deposit money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
            // Case C allows the user to withdraw money
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
            // Case D allows the user to view the most recent transaction
                case 'D':
                    System.out.println("==================");
                    getPreviousTransaction();
                    System.out.println("==================");
                    System.out.println();
                    break;
            // Case E exits the user from their account
                case 'E':
                    System.out.println("===================");
                    break;
            // the default case lets the user know they entered an invalid operation
                default:
                    System.out.println("Error: invalid option, Please enter A, B, C, D or E");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for banking with us!");
    }

}
