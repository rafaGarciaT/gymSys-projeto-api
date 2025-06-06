package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.UnidadeRepository;
import com.grupo.gymSys.service.UnidadeService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeServiceImpl(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    @Override
    public Unidade findById(Long id) {
        return unidadeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Unidade create(Unidade unidadeToCreate) {
        if (unidadeRepository.existsByCep(unidadeToCreate.getCep())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse Cep.");
        }
        if (unidadeRepository.existsByEndereco(unidadeToCreate.getEndereco())){
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse Endereco.");
        }
        return unidadeRepository.save(unidadeToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!unidadeRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhuma unidade encontrado com esse id.");
        }
        unidadeRepository.deleteById(id);
    }

    @Override
    public Unidade update(Long id, Unidade updatedUnidade) {
        Unidade existingUnidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhuma unidade encontrada com esse id."));


        existingUnidade.setEndereco(updatedUnidade.getEndereco());
        existingUnidade.setCidade(updatedUnidade.getCidade());
        existingUnidade.setEstado(updatedUnidade.getEstado());
        existingUnidade.setNumero(updatedUnidade.getNumero());
        existingUnidade.setCep(updatedUnidade.getCep());


        return unidadeRepository.save(existingUnidade);
    }
}
