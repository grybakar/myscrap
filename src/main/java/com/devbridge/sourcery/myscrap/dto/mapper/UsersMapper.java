package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.UsersDto;
import com.devbridge.sourcery.myscrap.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersMapper {
  private final MapperConfig mapperConfig;

  public UsersDto mapToDto(Users users) {
    return mapperConfig.modelMapper().map(users, UsersDto.class);
  }

  public Users mapToEntity(UsersDto usersDto) {
    return mapperConfig.modelMapper().map(usersDto, Users.class);
  }
}
