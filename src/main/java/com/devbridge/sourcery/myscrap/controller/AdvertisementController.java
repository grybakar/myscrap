package com.devbridge.sourcery.myscrap.controller;


import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.dto.AdvertisementSearchCriteria;
import com.devbridge.sourcery.myscrap.service.AdvertisementService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/advertisements")
@Slf4j
public class AdvertisementController {

  public final AdvertisementService advertisementService;

  @GetMapping("/search")
  @Transactional
  public ResponseEntity<List<AdvertisementDto>> findAllByItemName(@RequestParam String name) {
    List<AdvertisementDto> advertisementsDto = advertisementService.findAllByItemName(name);
    return new ResponseEntity<>(advertisementsDto, HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<List<AdvertisementDto>> findByItemId(@RequestBody AdvertisementSearchCriteria searchCriteria) {
    List<AdvertisementDto> filteredAdvertisements = advertisementService.findByItemIdAndFilters(searchCriteria);
    return new ResponseEntity<>(filteredAdvertisements, HttpStatus.OK);
  }

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  @Transactional
  public ResponseEntity<AdvertisementDto> save(
    @ModelAttribute AdvertisementDto advertisementDto,
    @RequestPart MultipartFile file) {
    return new ResponseEntity<>(advertisementService.save(advertisementDto, file), HttpStatus.OK);
  }
}
