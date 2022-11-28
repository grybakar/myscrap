package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
