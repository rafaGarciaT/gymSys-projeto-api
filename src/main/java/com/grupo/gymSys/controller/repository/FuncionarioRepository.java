package com.grupo.gymSys.controller.repository;

import com.grupo.gymSys.controller.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
