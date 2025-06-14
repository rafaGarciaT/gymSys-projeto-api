package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UnidadeDTO;
import com.grupo.gymSys.domain.model.Unidade;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnidadeMapper {
    UnidadeMapper INSTANCE = Mappers.getMapper(UnidadeMapper.class);

    Unidade toEntity(UnidadeDTO dto);

    UnidadeDTO toDTO(Unidade entity);
}
