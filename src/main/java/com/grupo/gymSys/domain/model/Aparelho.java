package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "tb_aparelhos")
public class Aparelho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String tipo;
    private int quantidade;
    private String UltimaManutencao;

    @OneToMany(mappedBy = "aparelho")
    private List<UnidadeAparelho> unidadeAparelhos;

    public Aparelho(String tipo, int quantidade, String ultimaManutencao) {
        this.id = id;
        UltimaManutencao = ultimaManutencao;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Aparelho() {

    }

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

    public String getUltimaManutencao() {
        return UltimaManutencao;
    }

    public void setUltimaManutencao(String UltimaMenutencao) {
        this.UltimaManutencao = UltimaMenutencao;
    }

    public List<UnidadeAparelho> getUnidadeAparelhos() {
        return unidadeAparelhos;
    }

    public void setUnidadeAparelhos(List<UnidadeAparelho> unidadeAparelhos) {
        this.unidadeAparelhos = unidadeAparelhos;
    }
}
