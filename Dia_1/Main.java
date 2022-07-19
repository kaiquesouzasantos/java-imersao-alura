package Dia_1;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        links para a requisição do JSON
            "https://api.mocki.io/v2/549a5d8b"
            "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"
            "https://alura-imdb-api.herokuapp.com/movies"
            "https://api.mocki.io/v2/549a5d8b"
            "https://alura-filmes.herokuapp.com/conteudos"
            "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm"
         */

        // conexão HTTP
        URI endereco = URI.create("https://api.mocki.io/v2/549a5d8b");
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair dados interresantes (titulo, poster, classificação) -> parciar os dados
        List<Map<String, String>> listaFilmes = new JsonParser().parse(body);

        // exibição
        for (Map<String,String> filme : listaFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
