package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ClassificatorDto;
import com.devbridge.sourcery.myscrap.model.Classificator;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassificatorMapper {


  ClassificatorDto toClassificatorDto(Classificator classificator);

  Classificator toClassificatorEntity(ClassificatorDto classificatorDto);

}
