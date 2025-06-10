package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UsuarioDTO;
import com.grupo.gymSys.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioMapperTest {

    private final UsuarioMapper mapper = UsuarioMapper.INSTANCE;

    @Test
    void shouldMapUsuarioToDto() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Ana");
        usuario.setEmail("ana@example.com");

        UsuarioDTO dto = mapper.toDTO(usuario);

        assertEquals("Ana", dto.getNome());
        assertEquals("ana@example.com", dto.getEmail());
    }

    @Test
    void shouldMapDtoToUsuario() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(2L);
        dto.setNome("Bruno");
        dto.setEmail("bruno@example.com");

        Usuario usuario = mapper.toEntity(dto);

        assertEquals("Bruno", usuario.getNome());
        assertEquals("bruno@example.com", usuario.getEmail());
    }
}