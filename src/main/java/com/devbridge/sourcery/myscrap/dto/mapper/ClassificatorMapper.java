package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ClassificatorDto;
import com.devbridge.sourcery.myscrap.model.Classificator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassificatorMapper {


  ClassificatorDto toClassificatorDto(Classificator classificator);

  @Mapping(target = "items", ignore = true)
  Classificator toClassificatorEntity(ClassificatorDto classificatorDto);

}
