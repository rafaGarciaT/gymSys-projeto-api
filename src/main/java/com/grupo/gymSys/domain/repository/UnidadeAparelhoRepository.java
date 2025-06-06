package com.grupo.gymSys.domain.repository;

import com.grupo.gymSys.domain.model.UnidadeAparelho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadeAparelhoRepository extends JpaRepository<UnidadeAparelho, Long> {
    List<UnidadeAparelho> findByUnidadeId(Long unidadeId);
    List<UnidadeAparelho> findByAparelhoId(Long aparelhoId);
    Optional<UnidadeAparelho> findByUnidadeIdAndAparelhoId(Long unidadeId, Long aparelhoId);
}
