package API;

import API.Conexao.ClienteHttp;
import API.Tratamento.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // url -> nasa, image -> imdb
        List<Conteudo> listaConteudo = new ExtratorConteudo()
                .extraiConteudos(new ClienteHttp()
                                .buscaDados("https://api.mocki.io/v2/549a5d8b"),
                "image");

        for (Conteudo item : listaConteudo) {
            new GeradorFigurinhas().cria(
                    new URL(item.getUrlImagem()).openStream(),
                    item.getTitulo() + ".jpg"
            );

            System.out.println(item.getTitulo());
        }
    }
}
