package com.grupo.gymSys.domain.dto;

import com.grupo.gymSys.domain.model.Funcionario;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UnidadeDTO {


    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo.")
    private long id;

    @NotBlank(message = "Campo endereço obrigatorio.")
    private String endereco;

    @Size(max = 100, message = "Cidade nao pode passar de 100 caracteres.")
    @NotBlank(message = "Campo cidade obrigatorio.")
    private String cidade;

    @Size(max = 100, message = "estado nao pode passar de 100 caracteres.")
    @NotBlank(message = "Campo estado obrigatorio.")
    private String estado;

    @NotBlank(message = "Campo numero obrigatorio.")
    private String numero;

    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP precisa seguir formato 12345-678.")
    @NotBlank(message = "Campo cep obrigatorio.")
    private String cep;


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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
