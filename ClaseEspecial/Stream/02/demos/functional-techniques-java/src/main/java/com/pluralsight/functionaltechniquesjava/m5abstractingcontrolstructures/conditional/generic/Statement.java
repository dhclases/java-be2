package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.conditional.generic;

import java.util.function.Supplier;

public class Statement<T> {

    public Supplier<Boolean> condition;
    public T action;

    public Statement(Supplier<Boolean> condition, T action) {
        this.condition = condition;
        this.action = action;
    }
}