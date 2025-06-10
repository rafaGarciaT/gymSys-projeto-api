package com.grupo.gymSys.domain.repository;

import com.grupo.gymSys.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmailIgnoreCase(String Email);

    boolean existsByTelefone(String Telefone);
}
