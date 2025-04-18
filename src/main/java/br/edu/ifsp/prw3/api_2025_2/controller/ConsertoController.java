package br.edu.ifsp.prw3.api_2025_2.controller;


import br.edu.ifsp.prw3.api_2025_2.dto.DadosConserto;
import br.edu.ifsp.prw3.api_2025_2.models.Conserto;
import br.edu.ifsp.prw3.api_2025_2.repository.ConsertoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    private final ConsertoRepository consertoRepository;

    public ConsertoController(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto conserto) {
        consertoRepository.save(new Conserto(conserto));
    }



    @GetMapping
    public String listar(){
        return "Olá Mundo!";
    }

}
