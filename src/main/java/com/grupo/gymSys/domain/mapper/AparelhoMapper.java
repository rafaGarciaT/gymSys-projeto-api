package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.AparelhoDTO;
import com.grupo.gymSys.domain.model.Aparelho;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AparelhoMapper {
    AparelhoMapper INSTANCE = Mappers.getMapper(AparelhoMapper.class);

    Aparelho toEntity(AparelhoDTO dto);

    AparelhoDTO toDTO(Aparelho entity);
}
