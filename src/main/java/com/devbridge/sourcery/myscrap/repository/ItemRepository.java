package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  List<Item> findItemsByCategoriesId(@Param("categoriesId") Long categoriesId);

  List<Item> findItemsByName(@Param("name") String name);


}
