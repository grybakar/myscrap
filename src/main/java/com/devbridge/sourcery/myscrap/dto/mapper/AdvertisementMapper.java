package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.model.Advertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvertisementMapper {

  private final MapperConfig mapperConfig;

  public AdvertisementDto mapToDto(Advertisement advertisement) {
    return mapperConfig.modelMapper().map(advertisement, AdvertisementDto.class);
  }

  public Advertisement mapToEntity(AdvertisementDto advertisementDto) {
    return mapperConfig.modelMapper().map(advertisementDto, Advertisement.class);
  }


}
