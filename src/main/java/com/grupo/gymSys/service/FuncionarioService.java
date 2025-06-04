package com.grupo.gymSys.service;

import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.domain.model.Usuario;

public interface FuncionarioService {
    Funcionario findById(Long id);

    Funcionario create(Funcionario userToCreate);

    void deleteById(Long id);
}
