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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public Page<DadosListagemAulas> getAll(@PageableDefault(size = 5, sort = {"titulo"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAulas::new);
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroAula dados) {
        repository.save(new Aula(dados));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosAtualizarAula dados){
        var aula = repository.getReferenceById(dados.id());
        aula.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
