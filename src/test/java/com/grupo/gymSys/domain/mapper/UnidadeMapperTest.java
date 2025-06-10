package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UnidadeDTO;
import com.grupo.gymSys.domain.mapper.UnidadeMapper;
import com.grupo.gymSys.domain.model.Unidade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnidadeMapperTest {

    private final UnidadeMapper mapper = UnidadeMapper.INSTANCE;

    @Test
    void shouldMapUnidadeToDto() {
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        unidade.setEndereco("Rua A");
        unidade.setCidade("São Paulo");
        unidade.setEstado("SP");
        unidade.setNumero("123");
        unidade.setCep("12345-678");

        UnidadeDTO dto = mapper.toDTO(unidade);

        assertEquals("Rua A", dto.getEndereco());
        assertEquals("São Paulo", dto.getCidade());
        assertEquals("SP", dto.getEstado());
        assertEquals("123", dto.getNumero());
        assertEquals("12345-678", dto.getCep());
    }

    @Test
    void shouldMapDtoToUnidade() {
        UnidadeDTO dto = new UnidadeDTO();
        dto.setId(2L);
        dto.setEndereco("Av. B");
        dto.setCidade("Rio de Janeiro");
        dto.setEstado("RJ");
        dto.setNumero("456");
        dto.setCep("87654-321");

        Unidade unidade = mapper.toEntity(dto);

        assertEquals("Av. B", unidade.getEndereco());
        assertEquals("Rio de Janeiro", unidade.getCidade());
        assertEquals("RJ", unidade.getEstado());
        assertEquals("456", unidade.getNumero());
        assertEquals("87654-321", unidade.getCep());
    }
}
