package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_unidade_aparelhos")
public class UnidadeAparelho {
    @Id
    @GeneratedValue
    private Long id;

    private int quantidade;
    private LocalDate ultimaManutencao;

    @ManyToOne
    @JoinColumn(name = "unidade_id", nullable = false)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "aparelho_id", nullable = false)
    private Aparelho aparelho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public LocalDate getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(LocalDate ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
