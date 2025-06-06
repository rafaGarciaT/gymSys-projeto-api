package com.grupo.gymSys.service;

import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Usuario;

public interface AparelhoService
    {
        Aparelho findById(Long id);

        Aparelho create(Aparelho userToCreate);

        void deleteById(Long id);

        Aparelho update(Long id, Aparelho updatedAparelho);
    }
