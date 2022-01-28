package aasales_bankapplication;

import java.util.Scanner;

public class Main {
    private static Bank bank;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu();
        boolean hasNext = true;

            while (hasNext) {
                try {
                    System.out.print("Please enter your option: ");
                    int choice = scanner.nextInt();

                    switch (choice){
                        case 1:
                            System.out.println("Exiting...");
                            hasNext = false;
                            break;
                        case 2:
                            addNewBank();
                            break;
                        case 3:
                            addNewBranch();
                            break;
                        case 4:
                            addNewCustomer();
                            break;
                        case 5:
                            addNewTransaction();
                            break;
                        case 6:
                            printBankDetails();
                            break;
                        case 7:
                            menu();
                            break;
                        default:
                            System.out.println("Please enter a valid option.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a number from 1 to 7.\n");
                    scanner.next();
                }
            }
    }

    public static void menu(){
        System.out.println(
                "\nSelect: \n" +
                        "1 - to Exit\n" +
                        "2 - to Add a new Bank\n" +
                        "3 - to Add a new Branch to a Bank\n" +
                        "4 - to Add a new Customer to a Branch\n" +
                        "5 - to Add a new Transaction to a Customer\n" +
                        "6 - to List all Bank Details\n" +
                        "7 - to Display Menu\n"
        );
    }

    private static void addNewBank() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the new bank: ");
            String name = scanner.nextLine();
            bank = new Bank(name);
            System.out.println("The bank " + bank.getName() + " has been created.\n");
        } catch (Exception e){
            System.out.println("Error: " +e.getMessage());
            System.out.println("Bank creation unsuccessful.\n");
        }
    }

    private static void addNewBranch() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type the branch name: ");
            String name = scanner.nextLine();
            if(bank.addBranch(name)) {
                System.out.println(name + " was added as a new branch.\n");
            } else{
                System.out.println("It was not possible to create this branch.\n");
            }
        } catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
    }

    private static void addNewCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the branch name: ");
            String branch = scanner.nextLine();
            System.out.println("Enter customer name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the transaction amount: ");
            double amount = scanner.nextDouble();
            if (bank.addCustomer(branch, name, amount)){
                System.out.println("Customer added successfully.\n");
            }else{
                System.out.println("Could not add this customer at this time.\n");
            }
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    private static void addNewTransaction() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the branch name: ");
            String branch = scanner.nextLine();
            System.out.println("Enter the customer name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the transaction amount: ");
            double amount = scanner.nextDouble();
            if (bank.addCustomerTransaction(branch, name, amount)){
                System.out.println("Customer transaction added successfully.\n");
            } else{
                System.out.println("It was not possible to save this transaction.\n");
            }
        } catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
    }

    private static void printBankDetails() {
        System.out.println("\n=====BANK DETAILS=====\n");
        System.out.println(bank);
        System.out.println("\n==================================================\n");
    }
}
