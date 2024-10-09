package com.atividade5.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.atividade5.demo.model.Usuario;
import com.atividade5.demo.repository.UsuarioRepository;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario-list"; // Nome da página HTML (listarUsuarios.html)
    }

    @GetMapping("/criar")
    public String mostrarFormCriar() {
        return "usuario-cadastrar"; // Nome da página HTML (criarUsuario.html)
    }

    @PostMapping("/criar")
    public String criar(@ModelAttribute Usuario usuario, Model model) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/listar"; // Redireciona para a lista após a criação
    }
}