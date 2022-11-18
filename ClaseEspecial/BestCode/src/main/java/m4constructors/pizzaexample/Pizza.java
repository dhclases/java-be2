package m4constructors.pizzaexample;

class Pizza {

    static class Builder {
        //mandatory
        private final int size;

        // default is false
        private boolean cheese;
        private boolean ham;

        Builder(int size) {
            this.size = size;
        }

        Builder cheese(boolean value) {
            cheese = value;
            return this;
        }

        Builder ham(boolean value) {
            ham = value;
            return this;
        }

        Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        int size = builder.size;
        boolean cheese = builder.cheese;
        boolean ham = builder.ham;
    }
}
