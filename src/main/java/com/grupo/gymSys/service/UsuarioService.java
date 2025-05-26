package com.grupo.gymSys.service;

import com.grupo.gymSys.domain.model.Usuario;

public interface UsuarioService {
    Usuario findById(Long id);

    Usuario create(Usuario userToCreate);

    void deleteById(Long id);
}
