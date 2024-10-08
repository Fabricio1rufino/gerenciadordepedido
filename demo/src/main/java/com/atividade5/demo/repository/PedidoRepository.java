package com.atividade5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade5.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}