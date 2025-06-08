package com.grupo.gymSys.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "tb_unidades")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String endereco;

    private String cidade;
    private String estado;

    private String numero;
    private String cep;

    @OneToMany(mappedBy = "unidade")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "unidade")
    private List<UnidadeAparelho> unidadeAparelhos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<UnidadeAparelho> getUnidadeAparelhos() {
        return unidadeAparelhos;
    }

    public void setUnidadeAparelhos(List<UnidadeAparelho> unidadeAparelhos) {
        this.unidadeAparelhos = unidadeAparelhos;
    }
}
