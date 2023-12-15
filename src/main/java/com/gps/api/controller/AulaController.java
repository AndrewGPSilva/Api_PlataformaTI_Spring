package com.gps.api.controller;

import com.gps.api.aula.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aulas")
public class AulaController {

    // Devolvendo o código HTTP 201

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemAulas>> getAll(@PageableDefault(size = 5, sort = {"titulo"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemAulas::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DadosCadastroAula dados) {
        repository.save(new Aula(dados));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAula> update(@RequestBody @Valid DadosAtualizarAula dados){
        var aula = repository.getReferenceById(dados.id());
        aula.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAula(aula));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
