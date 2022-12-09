package com.devbridge.sourcery.myscrap.dto;

import java.util.List;
import lombok.Data;

@Data
public class ItemsClassificatorsDto {

  private Long itemId;
  private String itemName;
  private List<String> classificators;
}
