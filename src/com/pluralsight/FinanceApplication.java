package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.Valuable;

import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Portfolio portfolio = new Portfolio("My Portfolio", "User");

        while (true) {
            System.out.println("\n1. Add Bank Account");
            System.out.println("2. Show Portfolio Value");
            System.out.println("3. Show Most Valuable Asset");
            System.out.println("4. Show Least Valuable Asset");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    int accNum = Integer.parseInt(scanner.nextLine());
                    System.out.print("Account Holder: ");
                    String holder = scanner.nextLine();
                    System.out.print("Balance: ");
                    double balance = Double.parseDouble(scanner.nextLine());

                    Valuable newAccount = new BankAccount(accNum, holder, balance);
                    portfolio.add(newAccount);
                    System.out.println("Account added!");
                    break;

                case 2:
                    System.out.println("Total Portfolio Value: $" + portfolio.getValue());
                    break;

                case 3:
                    Valuable most = portfolio.getMostValuable();
                    System.out.println("Most Valuable: " + ((BankAccount) most).getAccountHolder() +
                            " - $" + ((BankAccount) most).getBalance());
                    break;

                case 4:
                    Valuable least = portfolio.getLeastValuable();
                    System.out.println("Least Valuable: " + ((BankAccount) least).getAccountHolder() +
                            " - $" + ((BankAccount) least).getBalance());
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}