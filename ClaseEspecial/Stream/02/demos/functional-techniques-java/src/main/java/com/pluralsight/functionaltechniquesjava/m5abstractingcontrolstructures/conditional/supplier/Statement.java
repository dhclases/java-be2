package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.conditional.supplier;

import java.util.function.Supplier;

public class Statement<T> {

    public Supplier<Boolean> condition;
    public Supplier<T> action;

    public Statement(Supplier<Boolean> condition, Supplier<T> action) {
        this.condition = condition;
        this.action = action;
    }
}
