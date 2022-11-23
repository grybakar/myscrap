package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.dto.UsersDto;
import com.devbridge.sourcery.myscrap.dto.mapper.UsersMapper;
import com.devbridge.sourcery.myscrap.model.Users;
import com.devbridge.sourcery.myscrap.service.UsersService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UsersController {
  public final UsersService usersService;
  public final UsersMapper usersMapper;

  @GetMapping("/")
  public ResponseEntity<List<UsersDto>> getUsers() {
    List<UsersDto> usersDto = usersService.getUsers();
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<UsersDto>> getUsersById(@PathVariable(name = "id") Long id) {
    List<UsersDto> usersDto = usersService.getUsersById(id);
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<UsersDto> createUser(@Valid @RequestBody UsersDto usersDto) {
    Users usersRequest = usersMapper.mapToEntity(usersDto);
    Users user = usersService.createUser(usersRequest);
    UsersDto usersResponse = usersMapper.mapToDto(user);
    return new ResponseEntity<>(usersResponse,HttpStatus.CREATED);
  }

  @PostMapping("/{id}")
  public ResponseEntity<UsersDto> updateUser(@PathVariable(name = "id") Long id, @RequestBody UsersDto usersDto) {
    Users usersRequest = usersMapper.mapToEntity(usersDto);
    Users user = usersService.updateUser(id, usersRequest);
    UsersDto usersResponse = usersMapper.mapToDto(user);
    return ResponseEntity.ok().body(usersResponse);
  }
}
