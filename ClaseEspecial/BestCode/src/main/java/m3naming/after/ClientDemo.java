package m3naming.after;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        // clear, non-ambiguous variable name
        HttpResponse response = new WebHttpClient().sendGet("https://api.github.com/");

        System.out.println(response.getStatusLine().getStatusCode());
    }
}
