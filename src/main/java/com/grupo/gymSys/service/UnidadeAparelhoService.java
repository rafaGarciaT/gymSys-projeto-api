package com.grupo.gymSys.service;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.model.UnidadeAparelho;

import java.util.List;

public interface UnidadeAparelhoService {
    public UnidadeAparelho createOrUpdate(UnidadeAparelhoDTO dto);

    public List<UnidadeAparelho> listByUnidade(Long unidadeId);

    UnidadeAparelho findById(Long id);

    void deleteById(Long id);

}
