package com.devbridge.sourcery.myscrap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto {

  private Long id;
  private Double price;
  private Boolean isNew;
  private Boolean isUnpacked;
  private Boolean sellSeparately;
  @Column(name = "photo_url")
  private String photoUrl;
  private Double quantity;
  private Double quantityPerPack;
  private String description;
  private String itemAddress;
  private String availableTimeStart;
  private String availableTimeEnd;
  private Long itemId;
}
