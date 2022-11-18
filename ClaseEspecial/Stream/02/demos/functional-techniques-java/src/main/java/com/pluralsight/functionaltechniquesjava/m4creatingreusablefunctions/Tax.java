package com.pluralsight.functionaltechniquesjava.m4creatingreusablefunctions;

public class Tax {
    private double rate;

    public Tax(double rate) {
        this.rate = rate;
    }

    public double apply(double amount) {
        return rate * amount;
    }

    public static void main(String args[]) {
        Tax nationalTax = new Tax(0.2);
        Tax internationalTax = new Tax(0.3);

        System.out.println( nationalTax.apply(100) );
        System.out.println( internationalTax.apply(100) );
    }
}
