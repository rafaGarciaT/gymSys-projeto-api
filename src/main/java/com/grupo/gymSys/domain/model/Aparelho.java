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
    private String nome;

    @OneToMany(mappedBy = "aparelho", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<UnidadeAparelho> getUnidadeAparelhos() {
        return unidadeAparelhos;
    }

    public void setUnidadeAparelhos(List<UnidadeAparelho> unidadeAparelhos) {
        this.unidadeAparelhos = unidadeAparelhos;
    }
}
