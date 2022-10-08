package br.com.desafio.service;

import br.com.desafio.entidade.Contato;
import br.com.desafio.entidade.Pessoa;
import br.com.desafio.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class PessoaService extends BaseService {

    private PessoaRepository repository;

    public Pessoa save(Pessoa pessoa) {
        if (nonNull(pessoa)) {
            return repository.save(pessoa);
        }
        return null;
    }

    public List<Pessoa> listPessoas() {
        return repository.findAll();
    }

    public void deletePessoa(Integer id) {
        var obj = repository.findById(id);
        if (!obj.isEmpty()) {
            repository.delete(obj.get());
        }
    }

    public Pessoa updatePessoa(Integer id, Contato contato) {
        var pessoa = repository.findById(id);
        if (pessoa.isPresent()) {
            pessoa.get().setContatos(Arrays.asList(contato));
            repository.save(pessoa.get());
        }
        return null;
    }
}