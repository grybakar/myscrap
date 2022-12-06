package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.model.Advertisement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AdvertisementMapper {

  @Mapping(target = "userId", source = "users.id")
  @Mapping(target = "itemId", source = "item.id")
  AdvertisementDto toAdvertisementDto(Advertisement advertisement);

  @Mapping(target = "users", ignore = true)
  @Mapping(target = "users.id", source = "userId")
  @Mapping(target = "item", ignore = true)
  @Mapping(target = "item.id", source = "itemId")
  Advertisement toAdvertisementEntity(AdvertisementDto advertisementDto);


}
