package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ItemsClassificatorsDto;
import com.devbridge.sourcery.myscrap.model.Classificator;
import com.devbridge.sourcery.myscrap.model.Item;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemsClassificatorsMapper {

  @Mapping(target = "itemName", source = "item.name")
  @Mapping(target = "itemId", source = "item.id")
  @Mapping(target = "classificators", source = "classificators")
  ItemsClassificatorsDto mapToDto(Item item);

  List<Classificator> map(List<String> classificators);

  Classificator map(String name);

  default String map(Classificator classificator) {
    return classificator.getName();
  }
}
