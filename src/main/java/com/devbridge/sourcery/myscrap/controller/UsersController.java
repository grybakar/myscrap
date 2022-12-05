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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
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

  @GetMapping("/current")
  public ResponseEntity<UsersDto> getCurrentUser() {
    UsersDto usersDto = usersService.getCurrentUser();
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<UsersDto> createUser(@Valid @RequestBody UsersDto usersDto) {
    Users usersRequest = usersMapper.mapToEntity(usersDto);
    Users user = usersService.createUser(usersRequest);
    UsersDto usersResponse = usersMapper.mapToDto(user);
    return new ResponseEntity<>(usersResponse, HttpStatus.CREATED);
  }

  @PostMapping("/current")
  public ResponseEntity<UsersDto> updateCurrentUser(@RequestBody UsersDto usersDto) {
    Users userRequest = usersMapper.mapToEntity(usersDto);
    Users user = usersService.updateCurrentUser(userRequest);
    UsersDto userResponse = usersMapper.mapToDto(user);
    return ResponseEntity.ok().body(userResponse);
  }
}
