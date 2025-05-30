package com.grupo.gymSys.service;

import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.model.Usuario;

public interface UnidadeService {
    Unidade findById(Long id);

    Unidade create(Usuario userToCreate);

    void deleteById(Long id);
}
