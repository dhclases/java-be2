package m7classes;

import java.util.ArrayList;
import java.util.List;

public class CouplingExample1 {

    // Not programming to an Interface
    ArrayList<String> list = new ArrayList<>();


    void doSomething(ArrayList<String> list) {
        String firstElem = list.get(0);

        // do something with firstElem
    }

    void doSomethingElse(ArrayList<String> list) {
        String lastElem = list.get(list.size() - 1);

        // do something with lastElem
    }


    // Programming to an Interface
    List<String> list2 = new ArrayList<>();


    void doSomething2(List<String> list) {
        String firstElem = list.get(0);

        // do something with firstElem
    }

    void doSomethingElse2(List<String> list) {
        String lastElem = list.get(list.size() - 1);

        // do something with lastElem
    }
}
