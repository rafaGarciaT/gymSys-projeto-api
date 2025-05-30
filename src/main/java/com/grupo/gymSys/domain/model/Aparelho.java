package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_aparelhos")
public class Aparelho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String tipo;
    private int quantidade;
    private String UltimaMenutencao;

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
