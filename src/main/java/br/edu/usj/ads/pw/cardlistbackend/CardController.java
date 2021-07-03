package br.edu.usj.ads.pw.cardlistbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@ResponseBody
@CrossOrigin

public class CardController {
    
    @Autowired
    CardRepository cardRepository;

    @PostMapping(value="/cadastrar")
    public Card postCadastrar(@RequestBody Card card) {
        Card novoCard = cardRepository.save(card);

        return novoCard;
    }

    @GetMapping(value="/")
    public List<Card> getMostrarTodos(){
        List<Card> lista = cardRepository.findAll();
        return lista;
    }
    
    @GetMapping(value="/informacoes/{id}")
    public Card getInformacoes(@PathVariable Long id) {
        Card card = new Card();
        card = cardRepository.findById(id).get();
        return card;
    }
    
    @GetMapping(value="/apagar/{id}")
    public void getApagar(@PathVariable Long id) {
        cardRepository.deleteById(id);
    }
    
    
}
