package com.grupo.gymSys.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UnidadeAparelhoDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo.")
    private Long id;

    @NotNull(message = "Campo unidadeId obrigatorio.")
    @PositiveOrZero(message = "Campo unidadeId precisa ser 0 ou positivo.")
    private Long unidadeId;

    @NotNull(message = "Campo aparelhoId obrigatorio.")
    @PositiveOrZero(message = "Campo aparelhoId precisa ser 0 ou positivo.")
    private Long aparelhoId;

    @NotNull(message = "Campo quantidade obrigatorio.")
    @Positive(message = "Campo quantidade precisa ser positivo.")
    private Integer quantidade;

    @NotNull(message = "Campo ultimaManutencao obrigatorio.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate ultimaManutencao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(LocalDate ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getAparelhoId() {
        return aparelhoId;
    }

    public void setAparelhoId(Long aparelhoId) {
        this.aparelhoId = aparelhoId;
    }

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }
}
