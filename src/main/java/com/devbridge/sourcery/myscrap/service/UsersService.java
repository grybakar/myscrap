package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.UsersDto;
import com.devbridge.sourcery.myscrap.dto.mapper.UsersMapper;
import com.devbridge.sourcery.myscrap.model.Users;
import com.devbridge.sourcery.myscrap.repository.UsersRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
  public final UsersRepository usersRepository;
  public final UsersMapper usersMapper;

  public List<UsersDto> getUsers() {
    List<Users> users = usersRepository.findAll();
    return users
      .stream()
      .map(usersMapper::mapToDto)
      .collect(Collectors.toList());
  }

  public UsersDto getUserById(Long id) {
    Users usersById = usersRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("User with given id not found"));
    return usersMapper.mapToDto(usersById);
  }

  public Users createUser(Users user) {
    return usersRepository.save(user);
  }

  public Users updateUser(Long id, Users userRequest) {
    Users user = usersRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Id not found"));
    user.setName(userRequest.getName());
    user.setEmail(userRequest.getEmail());
    user.setPassword(userRequest.getPassword());
    user.setAddress(userRequest.getAddress());
    user.setPhone(userRequest.getPhone());
    return usersRepository.save(user);
  }
}
