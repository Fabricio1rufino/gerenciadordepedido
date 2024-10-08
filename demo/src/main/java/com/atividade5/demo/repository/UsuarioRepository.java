package com.atividade5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade5.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
