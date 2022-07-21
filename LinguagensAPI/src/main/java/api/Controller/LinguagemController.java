package api.Controller;

import api.Tratamento.Linguagem;
import api.Tratamento.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LinguagemController {
    @Autowired
    private LinguagemRepository respositorio;

    @GetMapping("/")
    public List<Linguagem> obterLinguagens(){
        return respositorio.findAll();
    }

    @PostMapping("/")
    public void adicionarLinguagem(@RequestBody Linguagem linguagem){
        // @RequestBody -> vem pelo corpo da requisição(json)
        respositorio.save(linguagem);
    }
}
