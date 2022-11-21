package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ClassificatorDto;
import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.model.Classificator;
import com.devbridge.sourcery.myscrap.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassificatorMapper {

  private final MapperConfig mapperConfig;

  public ClassificatorDto mapToDto(Classificator classificator) {
    return mapperConfig.modelMapper().map(classificator, ClassificatorDto.class);
  }

  public Classificator mapToEntity(ClassificatorDto classificatorDto) {
    return mapperConfig.modelMapper().map(classificatorDto, Classificator.class);
  }

}
