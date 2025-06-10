package com.grupo.gymSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.model.Aparelho;
import com.grupo.gymSys.domain.model.Unidade;
import com.grupo.gymSys.domain.repository.AparelhoRepository;
import com.grupo.gymSys.domain.repository.UnidadeAparelhoRepository;
import com.grupo.gymSys.domain.repository.UnidadeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnidadeAparelhoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private AparelhoRepository aparelhoRepository;

    @Autowired
    private UnidadeAparelhoRepository unidadeAparelhoRepository;

    private Aparelho existingAparelho;

    private Unidade existingUnidade;

    @BeforeEach
    void setup() {
        existingAparelho = new Aparelho();
        existingAparelho.setTipo("Esteira");
        existingAparelho.setQuantidade(5);
        existingAparelho.setUltimaManutencao(String.valueOf(LocalDate.now().minusMonths(2)));

        existingUnidade = new Unidade();
        existingUnidade.setEndereco("Rua A");
        existingUnidade.setCidade("Cidade X");
        existingUnidade.setEstado("Estado Y");
        existingUnidade.setNumero("123");
        existingUnidade.setCep("45678-000");

        existingAparelho = aparelhoRepository.save(existingAparelho);

        existingUnidade = unidadeRepository.save(existingUnidade);
    }

    @AfterAll
     void cleanup() {
        unidadeAparelhoRepository.deleteAll();
        aparelhoRepository.deleteAll();
        unidadeRepository.deleteAll();
    }

    @Test
    void shouldAssociateUnidadeAndAparelhoSuccessfully() throws Exception {
        UnidadeAparelhoDTO dto = new UnidadeAparelhoDTO();
        dto.setUnidadeId(existingUnidade.getId());
        dto.setAparelhoId(existingAparelho.getId());
        dto.setQuantidade(5);
        dto.setUltimaManutencao(LocalDate.now().minusDays(10));

        mockMvc.perform(post("/unidade-aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldListUnidadeAparelhoByUnidadeId() throws Exception {
        UnidadeAparelhoDTO dto = new UnidadeAparelhoDTO();
        dto.setUnidadeId(existingUnidade.getId());
        dto.setAparelhoId(existingAparelho.getId());
        dto.setQuantidade(5);
        dto.setUltimaManutencao(LocalDate.now().minusDays(10));

        mockMvc.perform(post("/unidade-aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/unidade-aparelhos/unidade/" + existingUnidade.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].unidadeId").value(existingUnidade.getId()));
    }

    @Test
    void shouldFailValidationOnMissingFields() throws Exception {
        UnidadeAparelhoDTO dto = new UnidadeAparelhoDTO();

        mockMvc.perform(post("/unidade-aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldFailIfUnidadeOrAparelhoNotFound() throws Exception {
        UnidadeAparelhoDTO dto = new UnidadeAparelhoDTO();
        dto.setUnidadeId(9999L);
        dto.setAparelhoId(9999L);
        dto.setQuantidade(1);
        dto.setUltimaManutencao(LocalDate.now());

        mockMvc.perform(post("/unidade-aparelhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertThat(result.getResolvedException())
                        .isInstanceOf(NoSuchElementException.class));
    }
}
