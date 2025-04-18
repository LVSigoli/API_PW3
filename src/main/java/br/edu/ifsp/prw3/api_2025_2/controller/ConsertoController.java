package br.edu.ifsp.prw3.api_2025_2.controller;
import br.edu.ifsp.prw3.api_2025_2.dto.ConsertoResumo;
import br.edu.ifsp.prw3.api_2025_2.dto.DadosAtualizacaoConserto;
import br.edu.ifsp.prw3.api_2025_2.dto.DadosConserto;
import br.edu.ifsp.prw3.api_2025_2.models.Conserto;
import br.edu.ifsp.prw3.api_2025_2.repository.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Void> cadastrar(@RequestBody DadosConserto conserto, UriComponentsBuilder uriBuilder) {
        Conserto novoConserto = new Conserto();

        consertoRepository.save(novoConserto);

        URI uri = uriBuilder.path("/consertos/{id}").buildAndExpand(novoConserto.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/todos")
    public Page<Conserto>listarTodos(Pageable pageable){
        return consertoRepository.findAll(pageable);
    }

    @GetMapping("/resumo")
    public List<ConsertoResumo> listarResumo() {
        return consertoRepository.findAll().stream().map(ConsertoResumo::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> buscarPorId(@PathVariable Long id) {
        return consertoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Conserto> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.setDataSaida(dados.dataSaida());
        conserto.getMecanico().setNome(dados.nomeMecanico());
        conserto.getMecanico().setAnosExperiencia(dados.anosExperiencia());
        return ResponseEntity.ok(conserto);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.setAtivo(false);
        return ResponseEntity.noContent().build();
    }


}
