package com.murilonerdx.vendasbackend.controller.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.murilonerdx.vendasbackend.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoFormRequest {
    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public ProdutoFormRequest(Long id, String descricao,
                              String nome, BigDecimal preco, String sku, LocalDate dataCadastro) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
        this.dataCadastro = dataCadastro;
    }

    public Produto toModel() {
        return new Produto(id, nome, descricao, preco, sku);
    }

    public static ProdutoFormRequest fromModel(Produto produto) {
        return new ProdutoFormRequest(
                produto.getId(),
                produto.getDescricao(),
                produto.getNome(),
                produto.getPreco(),
                produto.getSku(),
                produto.getDataCadastro()
        );
    }
}