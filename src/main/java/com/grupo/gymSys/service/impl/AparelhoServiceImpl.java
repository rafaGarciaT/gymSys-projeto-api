package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import com.grupo.gymSys.service.AparelhoService;
import com.grupo.gymSys.service.UnidadeAparelhoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AparelhoServiceImpl implements AparelhoService {

    private final AparelhoRepository aparelhoRepository;
    private final UnidadeAparelhoService unidadeAparelhoService;

    public AparelhoServiceImpl(AparelhoRepository aparelhoRepository,
                               UnidadeAparelhoService unidadeAparelhoService) {
        this.aparelhoRepository = aparelhoRepository;
        this.unidadeAparelhoService = unidadeAparelhoService;
    }

    @Override
    public Aparelho findById(Long id) {
        return aparelhoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aparelho create(Aparelho aparelhoToCreate) {
        if (aparelhoRepository.existsByNome(aparelhoToCreate.getNome())) {
            throw new IllegalArgumentException("Já existe um aparelho cadastrado com esse nome.");
        }

        return aparelhoRepository.save(aparelhoToCreate);
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

        if (aparelhoRepository.existsByNome(updatedAparelho.getNome())) {
            throw new IllegalArgumentException("Já existe um aparelho cadastrado com esse nome.");
        }

        existingAparelho.setTipo(updatedAparelho.getTipo());
        existingAparelho.setNome(updatedAparelho.getNome());

        return aparelhoRepository.save(existingAparelho);
    }

}
