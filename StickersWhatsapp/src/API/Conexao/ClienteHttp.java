package API.Conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
    public String buscaDados(String url) {
         /*
        links para a requisição do JSON -> imdb
            "https://api.mocki.io/v2/549a5d8b"
            "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"
            "https://alura-imdb-api.herokuapp.com/movies"
            "https://api.mocki.io/v2/549a5d8b"
            "https://alura-filmes.herokuapp.com/conteudos"
            "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm"

        links para a requisição do JSON -> nasa
            "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json"
            "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14"
         */

        try{
            URI endereco = URI.create(url);
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }catch (IOException | InterruptedException e){throw new RuntimeException(e);}
    }
}
