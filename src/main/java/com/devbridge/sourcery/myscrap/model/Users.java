package com.devbridge.sourcery.myscrap.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String password;
  private String address;
  private String phone;
  @CreationTimestamp
  private Timestamp createdOn;
}
