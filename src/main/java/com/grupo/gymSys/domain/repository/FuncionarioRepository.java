package com.grupo.gymSys.domain.repository;

import com.grupo.gymSys.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
