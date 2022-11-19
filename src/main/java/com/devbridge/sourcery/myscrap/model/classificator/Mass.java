package com.devbridge.sourcery.myscrap.model.classificator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Double weight;


}
