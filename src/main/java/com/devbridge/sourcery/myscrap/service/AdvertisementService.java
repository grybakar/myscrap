package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.dto.AdvertisementSearchCriteria;
import com.devbridge.sourcery.myscrap.dto.mapper.AdvertisementMapper;
import com.devbridge.sourcery.myscrap.exception.MyScrapException;
import com.devbridge.sourcery.myscrap.model.Advertisement;
import com.devbridge.sourcery.myscrap.repository.AdvertisementCriteriaRepository;
import com.devbridge.sourcery.myscrap.repository.AdvertisementRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AdvertisementService {

  public final AdvertisementRepository advertisementRepository;
  public final AdvertisementCriteriaRepository advertisementCriteriaRepository;
  public final AdvertisementMapper advertisementMapper;

  public List<AdvertisementDto> findAllByItemName(String name) {
    List<Advertisement> advertisementsByItemName = advertisementRepository.findAllByItemName(name);
    return advertisementsByItemName
      .stream()
      .map(advertisementMapper::mapToDto)
      .toList();
  }

  public List<AdvertisementDto> findByItemIdAndFilters(AdvertisementSearchCriteria searchCriteria) {
    log.info("Finding advertisements with given Filters: {}", searchCriteria);
    List<Advertisement> allByItemId = advertisementCriteriaRepository.findByItemIdWithFilter(searchCriteria);
    boolean isEmpty = allByItemId.isEmpty();
    if (isEmpty) {
      throw new MyScrapException("No advertisement found by given search criteria");
    }
    return allByItemId.stream()
      .map(advertisementMapper::mapToDto)
      .toList();
  }
}


