package br.com.desafio.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Pessoa implements Serializable {

    private Integer id;

    @OneToMany
    private List<Contato> contatos = new ArrayList<>();
}
