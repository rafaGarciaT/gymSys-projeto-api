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
        aparelho.setNome("Estoura");

        AparelhoDTO dto = mapper.toDTO(aparelho);

        assertEquals("Esteira", dto.getTipo());
        assertEquals("Estoura", dto.getNome());
    }

    @Test
    void shouldMapDtoToAparelho() {
        AparelhoDTO dto = new AparelhoDTO();
        dto.setId(2L);
        dto.setTipo("Bicicleta");
        dto.setNome("Bicicleta 20");

        Aparelho aparelho = mapper.toEntity(dto);

        assertEquals("Bicicleta", aparelho.getTipo());
        assertEquals("Bicicleta 20", aparelho.getNome());
    }
}
