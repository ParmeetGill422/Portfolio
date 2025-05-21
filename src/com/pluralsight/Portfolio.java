package com.pluralsight;

import com.pluralsight.finance.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable asset) {
        assets.add(asset);
    }

    public double getValue() {
        double total = 0;
        for (Valuable asset : assets) {
            if (asset instanceof com.pluralsight.finance.BankAccount) {
                total += ((com.pluralsight.finance.BankAccount) asset).getBalance();
            }
        }
        return total;
    }

    public Valuable getMostValuable() {
        Valuable max = null;
        double maxValue = Double.NEGATIVE_INFINITY;

        for (Valuable asset : assets) {
            if (asset instanceof com.pluralsight.finance.BankAccount) {
                double value = ((com.pluralsight.finance.BankAccount) asset).getBalance();
                if (value > maxValue) {
                    maxValue = value;
                    max = asset;
                }
            }
        }
        return max;
    }

    public Valuable getLeastValuable() {
        Valuable min = null;
        double minValue = Double.POSITIVE_INFINITY;

        for (Valuable asset : assets) {
            if (asset instanceof com.pluralsight.finance.BankAccount) {
                double value = ((com.pluralsight.finance.BankAccount) asset).getBalance();
                if (value < minValue) {
                    minValue = value;
                    min = asset;
                }
            }
        }
        return min;
    }
}