package api.Tratamento;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    // interface que herda as caracteristicas operacionas do banco de dados.
    // Sendo possivel a manipulação com metodos prontos(crud)
}
