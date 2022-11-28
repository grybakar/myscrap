package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Advertisement;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

  String ADVERTISEMENTS_WHERE_ITEM_NAME = "SELECT a FROM advertisements a WHERE lower(a.item.name) "
    + "LIKE lower(concat(:name,'%'))";

  @Query(value = ADVERTISEMENTS_WHERE_ITEM_NAME)
  List<Advertisement> findAllByItemName(@Param("name") String name);
}
