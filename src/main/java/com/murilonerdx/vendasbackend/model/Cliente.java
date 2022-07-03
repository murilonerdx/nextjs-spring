package com.murilonerdx.vendasbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate nascimento;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

}