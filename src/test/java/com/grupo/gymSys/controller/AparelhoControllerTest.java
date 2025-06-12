package com.grupo.gymSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.gymSys.domain.dto.AparelhoDTO;
import com.grupo.gymSys.domain.dto.UsuarioDTO;
import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Usuario;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AparelhoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AparelhoRepository aparelhoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Aparelho existingAparelho;

    @BeforeEach
    void setup() {
        existingAparelho = new Aparelho();
        existingAparelho.setTipo("Esteira");
        existingAparelho.setNome("Esteira 5000");

        existingAparelho = aparelhoRepository.save(existingAparelho);
    }

    @AfterAll
    void cleanup() {
        aparelhoRepository.deleteAll();
    }

    @Test
    void shouldGetAparelhoById() throws Exception {
        mockMvc.perform(get("/aparelhos/{id}", existingAparelho.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipo").value("Esteira"));
    }

    @Test
    void shouldCreateAparelhoSuccessfully() throws Exception {
        AparelhoDTO dto = new AparelhoDTO();
        dto.setTipo("Bicicleta");
        dto.setNome("Bicicletona");

        mockMvc.perform(post("/aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipo").value("Bicicleta"));
    }

    @Test
    void shouldFailToCreateAparelhoWithDuplicateName() throws Exception {
        AparelhoDTO dto = new AparelhoDTO();
        dto.setId(100);
        dto.setNome(existingAparelho.getNome());

        mockMvc.perform(post("/aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldUpdateAparelhoSuccessfully() throws Exception {
        AparelhoDTO dto = new AparelhoDTO();
        dto.setId(existingAparelho.getId());
        dto.setTipo("Esteira Atualizada");
        dto.setNome("Esteira 6000");

        mockMvc.perform(put("/aparelhos/{id}", existingAparelho.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Esteira 6000"));
    }

    @Test
    void shouldDeleteAparelhoSuccessfully() throws Exception {
        Aparelho aparelho = new Aparelho();
        aparelho.setTipo("Elíptico");
        aparelho.setNome("Lilítico");
        Aparelho saved = aparelhoRepository.save(aparelho);

        mockMvc.perform(delete("/aparelhos/{id}", saved.getId()))
                .andExpect(status().isNoContent());

        Assertions.assertFalse(aparelhoRepository.findById(saved.getId()).isPresent());
    }

    @Test
    void shouldFailToDeleteAparelhoWithNonexistentId() throws Exception {
        Aparelho aparelho = new Aparelho();
        aparelho.setNome("Escada 5000");
        aparelho.setTipo("Escada");
        Aparelho saved = aparelhoRepository.save(aparelho);

        mockMvc.perform(delete("/aparelhos/{id}", saved.getId()))
                .andExpect(status().isNoContent());
        Assertions.assertFalse(aparelhoRepository.findById(saved.getId()).isPresent());

        mockMvc.perform(delete("/aparelhos/{id}", saved.getId()))
                .andExpect(status().isNotFound());
        Assertions.assertFalse(aparelhoRepository.findById(saved.getId()).isPresent());
    }
}
