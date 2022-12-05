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

  public UsersDto getCurrentUser() {
    Users currentUser = usersRepository.findById(5L)
      .orElseThrow(() -> new IllegalArgumentException("No present user"));
    return usersMapper.mapToDto(currentUser);
  }

  public Users createUser(Users user) {
    return usersRepository.save(user);
  }

  public Users updateCurrentUser(Users usersRequest) {
    Users user = usersRepository.findById(5L)
      .orElseThrow(() -> new IllegalArgumentException("User not found"));
    user.setName(usersRequest.getName());
    user.setEmail(usersRequest.getEmail());
    user.setPassword(usersRequest.getPassword());
    user.setAddress(usersRequest.getAddress());
    user.setPhone(usersRequest.getPhone());
    return usersRepository.save(user);
  }
}
