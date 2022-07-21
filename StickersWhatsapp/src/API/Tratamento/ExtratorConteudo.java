package API.Tratamento;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ExtratorConteudo {
    public List<Conteudo> extraiConteudos(String json, String chaveImg) {
        // extrair só os dados que interessam (titulo, poster, classificação)

        List<Map<String, String>> listaAtributos = new ConversorJSON().parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaAtributos) {
            String titulo = atributos.get("title");
            String urlImagem;

            if(chaveImg.equalsIgnoreCase("image")) {
                urlImagem = atributos.get(chaveImg).replaceAll("(@+)(.*).jpg$", "$1.jpg");
            }else{
                urlImagem = atributos.get(chaveImg);
            }

            conteudos.add(new Conteudo(titulo, urlImagem));
        }

        return conteudos;
    }
}
