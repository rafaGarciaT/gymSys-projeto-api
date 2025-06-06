package com.grupo.gymSys.domain.dto;

import jakarta.validation.constraints.*;

public class AparelhoDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo")

    private long id;

    @NotBlank(message = "Campo tipo obrigatório.")
    @Size(max = 100, message = "Tipo não pode passar de 100 caracteres.")

    private String tipo;

    @NotNull(message = "Campo quantidade obrigatório")
    @Positive(message = "Quantidade precisa ser positivo")

    private int quantidade;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
