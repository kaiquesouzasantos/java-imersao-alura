package api.Tratamento;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linguagens")
// mongoDB -> noSQL, armazena documentos. Essa annotacion é a sua representação.
public class Linguagem {
    @Id
    private String id;

    private String title, image;
    private int ranking;


    public Linguagem() {}
    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getImage() {return image;}
    public int getRanking() {return ranking;}
}
