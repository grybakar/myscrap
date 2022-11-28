package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  String CATEGORIES_WHERE_CATEGORY_NAME = "SELECT a FROM categories a WHERE lower(a.categoryName) "
    + "LIKE lower(concat(:categoryName,'%'))";

  @Query(value = CATEGORIES_WHERE_CATEGORY_NAME)
  List<Category> findAllByCategoryName(@Param("categoryName") String categoryName);

}
