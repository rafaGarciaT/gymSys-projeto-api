package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.mapper.UnidadeAparelhoMapper;
import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnidadeAparelhoMapperTest {

    private final UnidadeAparelhoMapper mapper = UnidadeAparelhoMapper.INSTANCE;

    @Test
    void shouldMapUnidadeAparelhoToDto() {
        Unidade unidade = new Unidade();
        unidade.setId(10L);

        Aparelho aparelho = new Aparelho();
        aparelho.setId(20L);

        UnidadeAparelho entity = new UnidadeAparelho();
        entity.setId(1L);
        entity.setQuantidade(5);
        entity.setUltimaManutencao(LocalDate.of(2025, 6, 1));
        entity.setUnidade(unidade);
        entity.setAparelho(aparelho);

        UnidadeAparelhoDTO dto = mapper.toDTO(entity);

        assertEquals(10L, dto.getUnidadeId());
        assertEquals(20L, dto.getAparelhoId());
        assertEquals(5, dto.getQuantidade());
        assertEquals(LocalDate.of(2025, 6, 1), dto.getUltimaManutencao());
    }

    @Test
    void shouldMapDtoToUnidadeAparelho() {
        UnidadeAparelhoDTO dto = new UnidadeAparelhoDTO();
        dto.setUnidadeId(100L);
        dto.setAparelhoId(200L);
        dto.setQuantidade(3);
        dto.setUltimaManutencao(LocalDate.of(2025, 5, 15));

        UnidadeAparelho entity = mapper.toEntity(dto);
        assertEquals(100L, entity.getUnidade().getId());
        assertEquals(200L, entity.getAparelho().getId());
        assertEquals(3, entity.getQuantidade());
        assertEquals(LocalDate.of(2025, 5, 15), entity.getUltimaManutencao());
    }
}

