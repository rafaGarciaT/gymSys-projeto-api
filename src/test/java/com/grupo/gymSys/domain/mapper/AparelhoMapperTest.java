package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.AparelhoDTO;
import com.grupo.gymSys.domain.mapper.AparelhoMapper;
import com.grupo.gymSys.domain.model.Aparelho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AparelhoMapperTest {

    private final AparelhoMapper mapper = AparelhoMapper.INSTANCE;

    @Test
    void shouldMapAparelhoToDto() {
        Aparelho aparelho = new Aparelho();
        aparelho.setId(1L);
        aparelho.setTipo("Esteira");
        aparelho.setQuantidade(10);

        AparelhoDTO dto = mapper.toDTO(aparelho);

        assertEquals("Esteira", dto.getTipo());
        assertEquals(10, dto.getQuantidade());
    }

    @Test
    void shouldMapDtoToAparelho() {
        AparelhoDTO dto = new AparelhoDTO();
        dto.setId(2L);
        dto.setTipo("Bicicleta");
        dto.setQuantidade(5);

        Aparelho aparelho = mapper.toEntity(dto);

        assertEquals("Bicicleta", aparelho.getTipo());
        assertEquals(5, aparelho.getQuantidade());
    }
}
