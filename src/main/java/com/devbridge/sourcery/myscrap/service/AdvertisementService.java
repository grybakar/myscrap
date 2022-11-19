package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.dto.mapper.AdvertisementMapper;
import com.devbridge.sourcery.myscrap.model.Advertisement;
import com.devbridge.sourcery.myscrap.repository.AdvertisementRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AdvertisementService {

  public final AdvertisementRepository advertisementRepository;
  public final AdvertisementMapper advertisementMapper;

  public List<AdvertisementDto> findAllByItemName(String name) {
    List<Advertisement> advertisementsByItemName = advertisementRepository.findAllByItemName(name);
    return advertisementsByItemName
      .stream()
      .map(advertisementMapper::mapToDto)
      .collect(Collectors.toList());
  }
}
