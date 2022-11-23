package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

  List<Users> getUsersById(@Param("id") Long userId);
}