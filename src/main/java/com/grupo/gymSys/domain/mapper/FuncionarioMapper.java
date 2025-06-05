package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.FuncionarioDTO;
import com.grupo.gymSys.domain.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario toEntity(FuncionarioDTO dto);

    FuncionarioDTO toDTO(Funcionario entity);
}
