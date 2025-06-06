package com.grupo.gymSys.service.impl;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.mapper.UnidadeAparelhoMapper;
import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import com.grupo.gymSys.domain.repository.UnidadeAparelhoRepository;
import com.grupo.gymSys.domain.repository.UnidadeRepository;
import com.grupo.gymSys.service.UnidadeAparelhoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UnidadeAparelhoServiceImpl implements UnidadeAparelhoService {

    private final UnidadeAparelhoRepository repository;
    private final UnidadeRepository unidadeRepository;
    private final AparelhoRepository aparelhoRepository;
    private final UnidadeAparelhoMapper mapper;

    public UnidadeAparelhoServiceImpl(UnidadeAparelhoRepository repository,
                                  UnidadeRepository unidadeRepository,
                                  AparelhoRepository aparelhoRepository,
                                  UnidadeAparelhoMapper mapper) {
        this.repository = repository;
        this.unidadeRepository = unidadeRepository;
        this.aparelhoRepository = aparelhoRepository;
        this.mapper = mapper;
    }

    @Override
    public UnidadeAparelho createOrUpdate(UnidadeAparelhoDTO dto) {
        Unidade unidade = unidadeRepository.findById(dto.getUnidadeId())
                .orElseThrow(() -> new NoSuchElementException("Unidade não encontrada"));
        Aparelho aparelho = aparelhoRepository.findById(dto.getAparelhoId())
                .orElseThrow(() -> new NoSuchElementException("Aparelho não encontrado"));

        UnidadeAparelho entity = repository.findByUnidadeIdAndAparelhoId(dto.getUnidadeId(), dto.getAparelhoId())
                .orElse(mapper.toEntity(dto)); // map fields directly

        entity.setUnidade(unidade);
        entity.setAparelho(aparelho);

        return repository.save(entity);
    }

    @Override
    public List<UnidadeAparelho> listByUnidade(Long unidadeId) {
        return repository.findByUnidadeId(unidadeId);
    }
}
