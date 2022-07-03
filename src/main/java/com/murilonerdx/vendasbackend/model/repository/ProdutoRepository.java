package com.murilonerdx.vendasbackend.model.repository;


import com.murilonerdx.vendasbackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
