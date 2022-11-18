package m10maintainingcleancode;

import java.io.IOException;

public class BadCodeSnippets {

    boolean someBoolean; // could be private

    void someOtherMethod() {

        if (someBoolean == true) { // don't compare boolean with true/false
            // ...
        }
        try {
            getFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void getFile() throws IOException {
        // get the file
    }

    // Someone else's code
    public int lengthPlus(String str) {
        int len = 2;
        try {
            len += str.length();
        } catch (Throwable e) {
            System.out.println("argument was null");
        }
        return len;
    }
}
