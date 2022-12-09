package com.devbridge.sourcery.myscrap.model.classificator;

import com.devbridge.sourcery.myscrap.model.Advertisement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dimensions")
public class Dimension {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer length;
  private Integer width;
  private Integer height;

  @OneToOne
  @JoinColumn(name = "advertisements_id")
  private Advertisement advertisement;
}
