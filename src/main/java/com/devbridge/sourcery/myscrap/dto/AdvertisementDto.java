package com.devbridge.sourcery.myscrap.dto;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto {

  private Long id;
  private Double price;
  private Boolean isNew;
  private Boolean isUnpacked;
  private Boolean sellSeparately;
  private String photo_url;
  private Double quantity;
  private Double quantityPerPack;
  private String description;
  private String itemAddress;
  private LocalTime availableTimeStart;
  private LocalTime availableTimeEnd;

}
