package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import com.grupo.gymSys.domain.repository.UsuarioRepository;
import com.grupo.gymSys.service.AparelhoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AparelhoServiceImpl implements AparelhoService {

    private final AparelhoRepository AparelhoRepository;

    public AparelhoServiceImpl(AparelhoRepository AparelhoRepository) {
        this.AparelhoRepository = AparelhoRepository;
    }

    @Override
    public Aparelho findById(Long id) {
        return AparelhoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aparelho create(Aparelho userToCreate) {
        if (AparelhoRepository.existsByTipo(userToCreate.getTipo())) {
            throw new IllegalArgumentException("Já existe um Aparelho cadastrado com esse email.");
        }

        return AparelhoRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!AparelhoRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhum Aparelho encontrado com esse id.");
        }
        AparelhoRepository.deleteById(id);
    }
}
