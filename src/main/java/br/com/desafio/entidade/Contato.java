package br.com.desafio.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Contato implements Serializable {

    private Integer id;

    private String telefone;

    private String email;

    private String whatsapp;
}
