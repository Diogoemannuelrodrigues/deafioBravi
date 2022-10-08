package br.com.desafio.controller;

import br.com.desafio.entidade.Pessoa;
import br.com.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        service.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @GetMapping
    public List<Pessoa> pessoasList() {
        List<Pessoa> pessoas = service.listPessoas();
        return pessoas;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pessoa> deleteById(@PathVariable("id") Integer id) {
        service.deletePessoa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
