package com.murilonerdx.vendasbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item_venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column
    private Integer quantidade;
}