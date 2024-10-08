package com.atividade5.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atividade5.demo.model.Pedido;
import com.atividade5.demo.model.StatusEnum;
import com.atividade5.demo.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}/status")
    public Pedido mudarStatus(@PathVariable Long id, @RequestBody StatusEnum status) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.mudarStatus(status);
        return pedidoRepository.save(pedido);
    }
}