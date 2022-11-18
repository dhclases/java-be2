package m7classes;

public class ProximityRule {

    void methodA() {
        methodB();
    }

    private void methodB() {
        methodC();
    }

    private void methodC() {
        doThatThing();
    }

    void doThatThing() {

    }

    void someOtherMethod() {

    }

    void yetAnotherMethod() {

    }
}
