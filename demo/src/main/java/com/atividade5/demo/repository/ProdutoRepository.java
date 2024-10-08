package com.atividade5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade5.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}