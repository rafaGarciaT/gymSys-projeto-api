package com.grupo.gymSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.gymSys.domain.dto.UnidadeDTO;
import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.repository.UnidadeRepository;
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
public class UnidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Unidade existingUnidade;

    @BeforeEach
    void setup() {
        existingUnidade = new Unidade();
        existingUnidade.setEndereco("Rua A");
        existingUnidade.setCep("12345-678");
        existingUnidade.setCidade("São Paulo");
        existingUnidade.setEstado("SP");
        existingUnidade.setNumero("100");

        existingUnidade = unidadeRepository.save(existingUnidade);
    }

    @AfterAll
    void cleanup() {
        unidadeRepository.deleteAll();
    }

    @Test
    void shouldGetUnidadeById() throws Exception {
        mockMvc.perform(get("/unidades/{id}", existingUnidade.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep").value("12345-678"));
    }

    @Test
    void shouldCreateUnidadeSuccessfully() throws Exception {
        UnidadeDTO dto = new UnidadeDTO();
        dto.setEndereco("Rua B");
        dto.setCep("98765-432");
        dto.setCidade("Campinas");
        dto.setEstado("SP");
        dto.setNumero("200");

        mockMvc.perform(post("/unidades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cep").value("98765-432"));
    }

    @Test
    void shouldUpdateUnidadeSuccessfully() throws Exception {
        UnidadeDTO dto = new UnidadeDTO();
        dto.setId(existingUnidade.getId());
        dto.setEndereco("Rua Atualizada");
        dto.setCep("11111-111");
        dto.setCidade("Santos");
        dto.setEstado("SP");
        dto.setNumero("999");

        mockMvc.perform(put("/unidades/{id}", existingUnidade.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.endereco").value("Rua Atualizada"));
    }

    @Test
    void shouldDeleteUnidadeSuccessfully() throws Exception {
        Unidade unidade = new Unidade();
        unidade.setEndereco("Rua C");
        unidade.setCep("22222-222");
        unidade.setCidade("Osasco");
        unidade.setEstado("SP");
        unidade.setNumero("50");
        Unidade saved = unidadeRepository.save(unidade);

        mockMvc.perform(delete("/unidades/{id}", saved.getId()))
                .andExpect(status().isNoContent());

        Assertions.assertFalse(unidadeRepository.findById(saved.getId()).isPresent());
    }
}
