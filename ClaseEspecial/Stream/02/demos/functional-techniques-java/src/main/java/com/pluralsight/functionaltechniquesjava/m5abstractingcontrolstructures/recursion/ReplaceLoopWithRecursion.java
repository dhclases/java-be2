package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.recursion;

public class ReplaceLoopWithRecursion {
    public static void main(String args[]) {
        printWithLoop(10);
        printWithRecursion(10);
    }

    public static void printWithLoop(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void printWithRecursion(int i) {
        if(i > 0) {
            printWithRecursion(i-1);
            System.out.println(i);
        }
    }
}
