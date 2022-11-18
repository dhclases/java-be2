package m4constructors.pizzaexample;

public class App {


    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(12)
                                .cheese(true)
                                .ham(true)
                                .build();
        // deliver pizza
    }
}
