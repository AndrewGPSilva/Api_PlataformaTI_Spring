package com.gps.api.controller;

import com.gps.api.aula.Aula;
import com.gps.api.aula.AulaRepository;
import com.gps.api.aula.DadosCadastroAula;
import com.gps.api.aula.DadosListagemAulas;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public List<DadosListagemAulas> getAll(){
        return repository.findAll().stream().map(DadosListagemAulas::new).toList();
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroAula dados) {
        repository.save(new Aula(dados));
    }
}
