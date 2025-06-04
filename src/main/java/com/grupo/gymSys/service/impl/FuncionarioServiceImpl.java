package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.domain.repository.FuncionarioRepository;
import com.grupo.gymSys.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository FuncionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository FuncionarioRepository) {
        this.FuncionarioRepository = FuncionarioRepository;
    }

    @Override
    public Funcionario findById(Long id) {
        return FuncionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Funcionario create(Funcionario userToCreate) {
        if (FuncionarioRepository.existsByNome(userToCreate.getNome())) {
            throw new IllegalArgumentException("Já existe um Funcionario cadastrado com esse email.");
        }

        if (FuncionarioRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("Já existe um Funcionario cadastrado com esse telefone.");
        }

        return FuncionarioRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!FuncionarioRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhum Funcionario encontrado com esse id.");
        }
        FuncionarioRepository.deleteById(id);
    }
}

