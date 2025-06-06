package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name= "tb_aparelhos")
public class Aparelho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo")

    private long id;

    @NotBlank(message = "Campo X obrigatório.")
    @Size(max = 100, message = "X não pode passar de 100 caracteres.")

    private String tipo;

    @NotNull(message = "Campo X obrigatório")
    @Positive(message = "X precisa ser positivo")

    private int quantidade;
    private String UltimaMenutencao;

    @OneToMany(mappedBy = "aparelho")
    private List<UnidadeAparelho> unidadeAparelhos;

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

    public String getUltimaMenutencao() {
        return UltimaMenutencao;
    }

    public void setUltimaMenutencao(String UltimaMenutencao) {
        this.UltimaMenutencao = UltimaMenutencao;
    }

}
