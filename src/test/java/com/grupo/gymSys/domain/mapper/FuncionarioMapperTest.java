package com.grupo.gymSys.domain.mapper;
import com.grupo.gymSys.domain.dto.FuncionarioDTO;
import com.grupo.gymSys.domain.mapper.FuncionarioMapper;
import com.grupo.gymSys.domain.model.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioMapperTest {

    private final FuncionarioMapper mapper = FuncionarioMapper.INSTANCE;

    @Test
    void shouldMapFuncionarioToDto() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Carlos");
        funcionario.setCargo("Instrutor");
        funcionario.setSalario(3000.0);

        FuncionarioDTO dto = mapper.toDTO(funcionario);

        assertEquals("Carlos", dto.getNome());
        assertEquals("Instrutor", dto.getCargo());
        assertEquals(3000.0, dto.getSalario());
    }

    @Test
    void shouldMapDtoToFuncionario() {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(2L);
        dto.setNome("Daniela");
        dto.setCargo("Recepcionista");
        dto.setSalario(2500.0);

        Funcionario funcionario = mapper.toEntity(dto);

        assertEquals("Daniela", funcionario.getNome());
        assertEquals("Recepcionista", funcionario.getCargo());
        assertEquals(2500.0, funcionario.getSalario());
    }
}
