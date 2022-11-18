package com.pluralsight.functionaltechniquesjava.m7handlingerrors;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Result<T> {

    public static <T> Result<T> of(final T value) {
        return value != null
                ? success(value)
                : failure("Null value");
    }

    public static <T> Result<T> of(final T value, final String message) {
        return value != null
                ? success(value)
                : failure(message);
    }

    public static <T> Result<T> ofNullable(final T value) {
        return value != null
                ? success(value)
                : empty();
    }

    public abstract Result<T> filter(Predicate<T> p, String message);

    public abstract <U> Result<U> map(Function<T, U> f);

    public abstract <U> Result<U> flatMap(Function<T, Result<U>> f);

    public abstract T orElse(T defaultValue);
    public abstract T orElse(Supplier<T> defaultValue);

    public static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    public static <V> Result<V> failure(Exception e) {
        return new Failure<>(e);
    }

    public static <T> Result<T> failure(String message) {
        return new Failure<>(message);
    }

    public static <T> Result<T> failure(String message, Exception e) {
        return new Failure<>(new Exception(message, e));
    }

    public static <T, U> Result<T> failure(Failure<U> failure) {
        return new Failure<>(failure.exception);
    }

    public static <T> Result<T> empty() {
        return new Empty<>();
    }

    private static class Success<T> extends Result<T> {
        private final T value;

        private Success(T value) {
            this.value = value;
        }

        @Override
        public Result<T> filter(Predicate<T> p, String message) {
            try {
                return p.test(this.value)
                        ? success(this.value)
                        : failure(message);
            } catch (Exception e) {
                return failure(e);
            }
        }

        @Override
        public <U> Result<U> map(Function<T, U> f) {
            try {
                return success(f.apply(this.value));
            } catch (Exception e) {
                return failure(e);
            }
        }

        @Override
        public <U> Result<U> flatMap(Function<T, Result<U>> f) {
            try {
                return f.apply(this.value);
            } catch (Exception e) {
                return failure(e);
            }
        }

        @Override
        public T orElse(T defaultValue) {
            return this.value;
        }

        @Override
        public T orElse(Supplier<T> defaultValue) {
            return this.value;
        }

        @Override
        public String toString() {
            return String.format("Success: %s", this.value.toString());
        }
    }

    private static class Failure<T> extends Result<T> {
        private final Exception exception;

        private Failure(Exception e) {
            this.exception = e;
        }

        private Failure(String message) {
            this.exception = new Exception(message);
        }

        @Override
        public Result<T> filter(Predicate<T> p, String message) {
            return failure(this);
        }

        @Override
        public <U> Result<U> map(Function<T, U> f) {
            return failure(this);
        }

        @Override
        public <U> Result<U> flatMap(Function<T, Result<U>> f) {
            return failure(this);
        }

        @Override
        public T orElse(T defaultValue) {
            return defaultValue;
        }

        @Override
        public T orElse(Supplier<T> defaultValue) {
            return defaultValue.get();
        }

        @Override
        public String toString() {
            return String.format("Failure: %s", this.exception);
        }
    }

    private static class Empty<T> extends Result<T> {
        private Empty() {}

        @Override
        public Result<T> filter(Predicate<T> p, String message) {
            return empty();
        }

        @Override
        public <U> Result<U> map(Function<T, U> f) {
            return empty();
        }

        @Override
        public <U> Result<U> flatMap(Function<T, Result<U>> f) {
            return empty();
        }

        @Override
        public T orElse(final T defaultValue) {
            return defaultValue;
        }

        @Override
        public T orElse(Supplier<T> defaultValue) {
            return defaultValue.get();
        }

        @Override
        public String toString() {
            return "Empty";
        }
    }
}

