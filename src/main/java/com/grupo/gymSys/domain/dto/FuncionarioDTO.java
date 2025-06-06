package com.grupo.gymSys.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class FuncionarioDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo.")
    private long id;

    @NotNull(message = "Campo cargoId obrigatorio.")
    @Positive(message = "cargo precisa ser positivo.")
    private long cargoId;

    @NotNull(message = "Campo salarioId obrigatorio.")
    @Positive(message = "salarioId precisa ser positivo.")
    private long salarioId;



    private String nome;
    private String cargo;
    private Double salario;

    private long unidadeId;

}

