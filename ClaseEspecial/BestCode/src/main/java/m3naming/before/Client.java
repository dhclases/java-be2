package m3naming.before;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

// "Client" has many meanings, we have to look inside to realize that
// it is an HttpClient - so the class name can be improved
public class Client {

    private HttpClient client = getDefaultClient();

    public HttpResponse send(String s) throws IOException {
        return client.execute(new HttpGet(s));
    }

    private CloseableHttpClient getDefaultClient(){
        return HttpClientBuilder.create()
                .build();
    }
}
