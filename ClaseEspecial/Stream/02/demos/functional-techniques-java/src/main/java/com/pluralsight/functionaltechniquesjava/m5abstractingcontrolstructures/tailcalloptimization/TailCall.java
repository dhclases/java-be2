package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailcalloptimization;

import java.util.function.Supplier;
import java.util.stream.Stream;

public abstract class TailCall<T> {
    public abstract boolean isComplete();
    public abstract TailCall<T> next();
    public abstract T eval();

    private static class Done<T> extends TailCall<T> {
        private final T t;

        public Done(T t) {
            this.t = t;
        }

        @Override
        public boolean isComplete() {
            return true;
        }

        @Override
        public TailCall<T> next() {
            throw new IllegalStateException("There's no next");
        }

        @Override
        public T eval() {
            return t;
        }
    }

    private static class Suspend<T> extends TailCall<T> {
        private final Supplier<TailCall<T>> thunk;

        public Suspend(Supplier<TailCall<T>> thunk) {
            this.thunk = thunk;
        }

        @Override
        public boolean isComplete() {
            return false;
        }

        @Override
        public TailCall<T> next() {
            return thunk.get();
        }

        @Override
        public T eval() {
            /*TailCall<T> tailRec = this;
            while(!tailRec.isComplete()) {
                tailRec = tailRec.next();
            }
            return tailRec.eval();*/
            return Stream.iterate((TailCall<T>)this, TailCall::next)
                    .filter(TailCall::isComplete)
                    .findFirst()
                    .get()
                    .eval();
        }
    }

    public static <T> Done<T> done(T t) {
        return new Done<>(t);
    }

    public static <T> Suspend<T> suspend(Supplier<TailCall<T>> s) {
        return new Suspend<>(s);
    }
}
