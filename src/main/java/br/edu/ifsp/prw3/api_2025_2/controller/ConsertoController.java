package br.edu.ifsp.prw3.api_2025_2.controller;


import br.edu.ifsp.prw3.api_2025_2.dto.ConsertoResumo;
import br.edu.ifsp.prw3.api_2025_2.dto.DadosConserto;
import br.edu.ifsp.prw3.api_2025_2.models.Conserto;
import br.edu.ifsp.prw3.api_2025_2.repository.ConsertoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/todos")
    public Page<Conserto>listarTodos(Pageable pageable){

        return consertoRepository.findAll(pageable);
    }

    @GetMapping("/resumo")
    public List<ConsertoResumo> listarResumo() {
        return consertoRepository.findAll().stream().map(ConsertoResumo::new).toList();
    }

}
