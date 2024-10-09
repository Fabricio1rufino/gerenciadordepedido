package com.atividade5.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.atividade5.demo.model.Produto;
import com.atividade5.demo.repository.ProdutoRepository;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produto-list"; //
    }

    @GetMapping("/criar")
    public String mostrarFormCriar() {
        return "produto-cadastrar"; 
    }

    @PostMapping("/criar")
    public String criar(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos/listar"; 
    }
}