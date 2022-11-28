package com.devbridge.sourcery.myscrap.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsersDto {
  private Long id;
  @NotEmpty
  @Size(min = 2, message = "user name should have at least 2 characters")
  private String name;
  @NotEmpty
  @Email
  private String email;
  @NotEmpty
  @Size(min = 6, message = "password should have at least 6 characters")
  private String password;
  @NotEmpty
  private String address;
  @NotEmpty
  private String phone;
  private LocalDateTime createdOn;
}
