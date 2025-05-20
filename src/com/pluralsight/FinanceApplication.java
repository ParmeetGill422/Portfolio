package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.Valuable;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123, "Pam", 12500);
        Valuable account2 = new BankAccount(456, "Gary", 1500);

        account1.deposit(100);
        account2.deposit(100);

        System.out.println("Pam's balance: $" + account1.getBalance());
        System.out.println("Gary's balance: $" + ((BankAccount) account2).getBalance());
    }
}