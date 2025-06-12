package com.grupo.gymSys.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AparelhoDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo")
    private long id;

    @NotBlank(message = "Campo tipo obrigatório.")
    @Size(max = 100, message = "Tipo não pode passar de 100 caracteres.")
    private String tipo;

    @NotBlank(message = "Campo nome obrigatório.")
    @Size(max = 100, message = "Nome não pode passar de 100 caracteres.")
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
