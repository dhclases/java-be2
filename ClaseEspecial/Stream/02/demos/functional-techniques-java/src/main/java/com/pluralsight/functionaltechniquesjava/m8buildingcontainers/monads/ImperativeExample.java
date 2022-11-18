package com.pluralsight.functionaltechniquesjava.m8buildingcontainers.monads;

public class ImperativeExample {
    public static String trim(String s) {
        return s.trim();
    }

    public static String upperCase(String s) {
        return s.toUpperCase();
    }

    public static String exclamation(String s) {
        return s + "!";
    }

    public static String format(String s) {
        String s1 = trim(s);
        String s2 = upperCase(s1);
        String s3 = exclamation(s2);

        return s3;
    }

    public static String format2(String s) {
        return exclamation(upperCase(trim(s)));
    }

    public static void main(String args[]) {
        System.out.println(format(" hello "));
    }
}
