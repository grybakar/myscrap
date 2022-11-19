package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.dto.AdvertisementDto;
import com.devbridge.sourcery.myscrap.service.AdvertisementService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
