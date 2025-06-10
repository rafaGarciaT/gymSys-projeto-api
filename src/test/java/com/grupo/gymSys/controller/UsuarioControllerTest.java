package com.grupo.gymSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.gymSys.domain.dto.UsuarioDTO;
import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario existingUsuario;

    @BeforeEach
    void setup() {
        existingUsuario = new Usuario();
        existingUsuario.setNome("João");
        existingUsuario.setEmail("joao@email.com");
        existingUsuario.setTelefone("1199999-9999");

        this.existingUsuario = usuarioRepository.save(existingUsuario);
    }

    @AfterAll
    void teardown() {
        usuarioRepository.deleteAll();
    }

    @Test
    void shouldGetUsuarioById() throws Exception {
        mockMvc.perform(get("/usuarios/{id}", existingUsuario.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("joao@email.com"));
    }

    @Test
    void shouldReturnNotFoundWhenUsuarioDoesNotExist() throws Exception {
        mockMvc.perform(get("/usuarios/{id}", 99999))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateUsuarioSuccessfully() throws Exception {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Maria");
        dto.setEmail("maria@email.com");
        dto.setTelefone("1198888-8888");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("maria@email.com"));
    }

    @Test
    void shouldFailToCreateUsuarioWithDuplicateEmail() throws Exception {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome("Clara");
        dto.setEmail(existingUsuario.getEmail());
        dto.setTelefone("1190000-0000");

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldUpdateUsuarioSuccessfully() throws Exception {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(existingUsuario.getId());
        dto.setNome("João Atualizado");
        dto.setEmail("novo@email.com");
        dto.setTelefone("1188888-0000");

        mockMvc.perform(put("/usuarios/{id}", existingUsuario.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Atualizado"));
    }

    @Test
    void shouldDeleteUsuarioSuccessfully() throws Exception {
        Usuario user = new Usuario();
        user.setNome("Carlos");
        user.setEmail("carlos@email.com");
        user.setTelefone("1177777-7777");
        Usuario saved = usuarioRepository.save(user);

        mockMvc.perform(delete("/usuarios/{id}", saved.getId()))
                .andExpect(status().isNoContent());

        Assertions.assertFalse(usuarioRepository.findById(saved.getId()).isPresent());
    }
}
