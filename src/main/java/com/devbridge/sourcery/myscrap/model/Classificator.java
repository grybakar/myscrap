package com.devbridge.sourcery.myscrap.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "classificators")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Classificator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String description;

}
