package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.dto.ClassificatorDto;
import com.devbridge.sourcery.myscrap.model.Classificator;
import com.devbridge.sourcery.myscrap.service.ClassificatorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "/classificators")
public class ClassificatorController {

  private final ClassificatorService classificatorService;

  @GetMapping(path = "/")
  public ResponseEntity<List<ClassificatorDto>> findAllByItemName(@RequestParam String name) {
    List<ClassificatorDto> classificatorsByItemName = classificatorService.findAllByItemName(name);
    return new ResponseEntity<>(classificatorsByItemName, HttpStatus.OK);
  }
}
