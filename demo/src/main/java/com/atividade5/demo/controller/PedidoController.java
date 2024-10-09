package com.atividade5.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.atividade5.demo.model.Pedido;
import com.atividade5.demo.model.StatusEnum;
import com.atividade5.demo.repository.PedidoRepository;

import java.util.List;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "pedido-list"; 
    }

    @GetMapping("/criar")
    public String mostrarFormCriar() {
        return "pedido-cadastrar"; 
    }

    @PostMapping("/criar")
    public String criar(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos/listar"; 
    }

    @PutMapping("/{id}/status")
    public String mudarStatus(@PathVariable Long id, @ModelAttribute StatusEnum status, Model model) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.mudarStatus(status);
        pedidoRepository.save(pedido);
        return "redirect:/pedidos/listar";
    }
}