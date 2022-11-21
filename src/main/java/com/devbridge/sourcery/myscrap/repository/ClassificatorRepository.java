package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Classificator;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificatorRepository extends JpaRepository<Classificator, Long> {

  @Query(value = "select c from classificators c JOIN c.items i where i.name = :name")
  List<Classificator> findAllByItemName(@Param("name") String name);


}
