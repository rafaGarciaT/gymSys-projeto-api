package com.grupo.gymSys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.gymSys.domain.dto.FuncionarioDTO;
import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.domain.repository.FuncionarioRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Funcionario existingFuncionario;

    @BeforeEach
    void setup() {
        existingFuncionario = new Funcionario();
        existingFuncionario.setNome("Pedro");
        existingFuncionario.setCargo("Instrutor");
        existingFuncionario.setSalario(2500.00);

        existingFuncionario = funcionarioRepository.save(existingFuncionario);
    }

    @AfterAll
    void cleanup() {
        funcionarioRepository.deleteAll();
    }

    @Test
    void shouldGetFuncionarioById() throws Exception {
        mockMvc.perform(get("/funcionarios/{id}", existingFuncionario.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Pedro"));
    }

    @Test
    void shouldCreateFuncionarioSuccessfully() throws Exception {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setNome("Luana");
        dto.setCargo("Recepcionista");
        dto.setSalario(1800.00);
        dto.setUnidadeId(1);

        mockMvc.perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cargo").value("Recepcionista"));
    }

    @Test
    void shouldUpdateFuncionarioSuccessfully() throws Exception {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(existingFuncionario.getId());
        dto.setNome("Pedro Atualizado");
        dto.setCargo("Coordenador");
        dto.setSalario(3500.00);
        dto.setUnidadeId(2);

        mockMvc.perform(put("/funcionarios/{id}", existingFuncionario.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cargo").value("Coordenador"));
    }

    @Test
    void shouldDeleteFuncionarioSuccessfully() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos");
        funcionario.setCargo("Manutenção");
        funcionario.setSalario(2200.00);
        Funcionario saved = funcionarioRepository.save(funcionario);

        mockMvc.perform(delete("/funcionarios/{id}", saved.getId()))
                .andExpect(status().isNoContent());

        Assertions.assertFalse(funcionarioRepository.findById(saved.getId()).isPresent());
    }
}
