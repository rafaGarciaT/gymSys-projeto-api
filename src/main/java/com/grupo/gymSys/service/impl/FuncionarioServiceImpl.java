package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.domain.repository.FuncionarioRepository;
import com.grupo.gymSys.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository FuncionarioRepository) {
        this.funcionarioRepository = FuncionarioRepository;
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Funcionario create(Funcionario userToCreate) {
        if (funcionarioRepository.existsByNome(userToCreate.getNome())) {
            throw new IllegalArgumentException("Já existe um Funcionario cadastrado com esse email.");
        }

        if (funcionarioRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("Já existe um Funcionario cadastrado com esse telefone.");
        }

        return funcionarioRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhum Funcionario encontrado com esse id.");
        }
        funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario update(Long id, Funcionario updatedFuncionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhum funcionário encontrado com esse id."));


        existingFuncionario.setNome(updatedFuncionario.getNome());
        existingFuncionario.setCargo(updatedFuncionario.getCargo());
        existingFuncionario.setSalario(updatedFuncionario.getSalario());


        return funcionarioRepository.save(existingFuncionario);
    }

}


