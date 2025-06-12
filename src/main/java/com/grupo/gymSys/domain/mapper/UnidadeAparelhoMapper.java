package com.grupo.gymSys.domain.mapper;

import com.grupo.gymSys.domain.dto.UnidadeAparelhoDTO;
import com.grupo.gymSys.domain.model.UnidadeAparelho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UnidadeAparelhoMapper {
    UnidadeAparelhoMapper INSTANCE = Mappers.getMapper(UnidadeAparelhoMapper.class);

    @Mapping(source = "unidadeId", target = "unidade.id")
    @Mapping(source = "aparelhoId", target = "aparelho.id")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "ultimaManutencao", target = "ultimaManutencao")
    @Mapping(target = "id", ignore = true)
    UnidadeAparelho toEntity(UnidadeAparelhoDTO dto);

    @Mapping(source = "unidade.id", target = "unidadeId")
    @Mapping(source = "aparelho.id", target = "aparelhoId")
    UnidadeAparelhoDTO toDTO(UnidadeAparelho entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "unidade", ignore = true)
    @Mapping(target = "aparelho", ignore = true)
    void updateEntity(UnidadeAparelhoDTO dto, @MappingTarget UnidadeAparelho entity);
}
