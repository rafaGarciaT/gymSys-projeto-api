package com.grupo.gymSys.controller.repository;

import com.grupo.gymSys.controller.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
