package com.murilonerdx.vendasbackend.model;

import com.murilonerdx.vendasbackend.model.enums.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens = new java.util.ArrayList<>();

    @Column
    private BigDecimal total;

    @Column(name = "data_venda")
    private LocalDateTime dataCadastro;

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDateTime.now());
    }
}
