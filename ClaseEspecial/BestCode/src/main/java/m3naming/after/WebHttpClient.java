package m3naming.after;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * An HttpClient to communicate over HTTP
 */
public class WebHttpClient {

    private HttpClient client = getDefaultClient();

    public HttpResponse sendGet(String s) throws IOException {
        return client.execute(new HttpGet(s));
    }

    private CloseableHttpClient getDefaultClient() {
        return HttpClientBuilder.create()
                .build();
    }
}
