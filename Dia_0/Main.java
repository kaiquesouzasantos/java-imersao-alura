package Dia_0;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        URI uri = URI.create("https://imdb-api.com/en/API/Top250Movies/k_om97iutj");
        var client = HttpClient.newHttpClient();
        var resquest = HttpRequest.newBuilder(uri).build();

        String json = client.send(resquest, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(json);
    }
}