package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UsuarioDTO;
import com.grupo.gymSys.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario entity);
}
