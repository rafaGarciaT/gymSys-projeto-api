package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private String cargo;
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
