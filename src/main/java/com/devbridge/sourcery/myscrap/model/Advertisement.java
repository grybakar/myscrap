package com.devbridge.sourcery.myscrap.model;

import com.devbridge.sourcery.myscrap.model.classificator.Color;
import com.devbridge.sourcery.myscrap.model.classificator.Dimension;
import com.devbridge.sourcery.myscrap.model.classificator.Mass;
import com.devbridge.sourcery.myscrap.model.classificator.Volume;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "advertisements")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Advertisement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private LocalTime availableTimeStart;
  private LocalTime availableTimeEnd;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "item_Id")
  @JsonIgnore
  private Item item;

  @OneToOne(mappedBy = "advertisement")
  private Color color;

  @OneToOne(mappedBy = "advertisement")
  private Mass mass;

  @OneToOne(mappedBy = "advertisement")
  private Volume volume;

  @OneToOne(mappedBy = "advertisement")
  private Dimension dimension;

}
