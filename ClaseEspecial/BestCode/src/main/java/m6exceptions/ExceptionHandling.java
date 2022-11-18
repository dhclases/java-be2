package m6exceptions;

public class ExceptionHandling {

    public static void main(String[] args) {

        try {
//            isAdult(-1);
            isAdult2(-1);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    private static void isAdult(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private static void isAdult2(int age) throws IllegalArgumentException {
        if (age < 0) {
            // or custom IllegalAgeException
            throw new IllegalArgumentException("The age should be at least 0. Actual age value passed: " + age);
        }
    }
}
