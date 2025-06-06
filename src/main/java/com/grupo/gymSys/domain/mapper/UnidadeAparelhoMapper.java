package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UnidadeAparelhoMapper {
    UnidadeAparelhoMapper INSTANCE = Mappers.getMapper(UnidadeAparelhoMapper.class);

    UnidadeAparelho toEntity(UnidadeAparelhoDTO dto);

    UnidadeAparelhoDTO toDTO(UnidadeAparelho entity);
}
