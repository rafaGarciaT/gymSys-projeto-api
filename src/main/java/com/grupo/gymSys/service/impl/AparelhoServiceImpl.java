package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import com.grupo.gymSys.service.AparelhoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AparelhoServiceImpl implements AparelhoService {

    private final AparelhoRepository aparelhoRepository;

    public AparelhoServiceImpl(AparelhoRepository AparelhoRepository) {
        this.aparelhoRepository = AparelhoRepository;
    }

    @Override
    public Aparelho findById(Long id) {
        return aparelhoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aparelho create(Aparelho userToCreate) {
        if (aparelhoRepository.existsByTipo(userToCreate.getTipo())) {
            throw new IllegalArgumentException("Já existe um Aparelho cadastrado com esse email.");
        }

        return aparelhoRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        if (!aparelhoRepository.existsById(id)) {
            throw new NoSuchElementException("Nenhum Aparelho encontrado com esse id.");
        }
        aparelhoRepository.deleteById(id);
    }
    @Override
    public Aparelho update(Long id, Aparelho updatedAparelho) {
        Aparelho existingAparelho = aparelhoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhum aparelho encontrado com esse id."));


        existingAparelho.setTipo(updatedAparelho.getTipo());
        existingAparelho.setQuantidade(updatedAparelho.getQuantidade());
        existingAparelho.setUltimaManutencao(updatedAparelho.getUltimaManutencao());


        return aparelhoRepository.save(existingAparelho);
    }

}
