package com.devbridge.sourcery.myscrap.model.classificator;

import com.devbridge.sourcery.myscrap.model.Advertisement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Volume {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  Integer volume;

  @OneToOne
  @JoinColumn(name = "advertisements_id")
  Advertisement advertisement;
}
