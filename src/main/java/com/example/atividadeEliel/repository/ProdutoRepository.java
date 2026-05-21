package com.example.atividadeEliel.repository;

import com.example.atividadeEliel.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
