package m3naming.before;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        // poor variable name
        HttpResponse r = new Client().send("https://api.github.com/");
        System.out.println(r.getStatusLine().getStatusCode());
    }
}
