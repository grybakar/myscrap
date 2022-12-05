package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.ClassificatorDto;
import com.devbridge.sourcery.myscrap.dto.mapper.ClassificatorMapper;
import com.devbridge.sourcery.myscrap.model.Classificator;
import com.devbridge.sourcery.myscrap.repository.ClassificatorRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassificatorService {

  private final ClassificatorRepository classificatorRepository;
  private final ClassificatorMapper classificatorMapper;

  public List<ClassificatorDto> findAllByItemName(String name) {
    List<Classificator> classificatorsByItemName = classificatorRepository.findAllByItemName(name);
    return classificatorsByItemName
      .stream()
      .map(classificatorMapper::toClassificatorDto)
      .collect(Collectors.toList());
  }
}
