package com.grupo.gymSys.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class FuncionarioDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo.")
    private long id;

    @NotBlank(message = "Campo nome obrigatorio.")
    @Size(max = 100, message = "Nome nao pode passar de 100 caracteres.")
    private String nome;

    @NotBlank(message = "Campo cargo obrigatorio.")
    @Size(max = 100, message = "Cargo nao pode passar de 100 caracteres.")
    private String cargo;

    @NotNull(message = "Campo salario obrigatorio.")
    @Positive(message = "Salario precisa ser positivo.")
    private Double salario;

    @NotNull(message = "Campo unidadeId obrigatorio.")
    @Positive(message = "UnidadeId precisa ser positivo.")
    private long unidadeId;

    public long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}