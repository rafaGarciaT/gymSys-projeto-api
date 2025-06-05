package com.grupo.gymSys.domain.dto;


import jakarta.validation.constraints.*;


public class UsuarioDTO {
    @PositiveOrZero(message = "Campo Id precisa ser 0 ou positivo.")
    private Long id;

    @NotBlank(message = "Campo nome obrigatorio.")
    @Size(max = 100, message = "Nome nao pode passar de 100 caracteres.")
    private String nome;

    @NotBlank(message = "Campo email obrigatorio.")
    @Email(message = "Email tem que ser valido.")
    private String email;

    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$",
            message = "Campo telefone tem que ser um telefone valido.")
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
