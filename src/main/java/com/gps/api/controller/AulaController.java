package com.gps.api.controller;

import com.gps.api.aula.Aula;
import com.gps.api.aula.AulaRepository;
import com.gps.api.aula.DadosCadastroAula;
import com.gps.api.aula.DadosListagemAulas;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
