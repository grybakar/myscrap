package com.devbridge.sourcery.myscrap.repository;

import com.devbridge.sourcery.myscrap.dto.AdvertisementSearchCriteria;
import com.devbridge.sourcery.myscrap.model.Advertisement;
import com.devbridge.sourcery.myscrap.model.Item;
import com.devbridge.sourcery.myscrap.model.classificator.Color;
import com.devbridge.sourcery.myscrap.model.classificator.Dimension;
import com.devbridge.sourcery.myscrap.model.classificator.Mass;
import com.devbridge.sourcery.myscrap.model.classificator.Volume;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class AdvertisementCriteriaRepository {

  private final EntityManager entityManager;
  private final CriteriaBuilder criteriaBuilder;

  public AdvertisementCriteriaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.criteriaBuilder = entityManager.getCriteriaBuilder();
  }

  public List<Advertisement> findByItemIdWithFilter(AdvertisementSearchCriteria searchCriteria) {

    CriteriaQuery<Advertisement> cq = criteriaBuilder.createQuery(Advertisement.class);
    Root<Advertisement> root = cq.from(Advertisement.class);
    Predicate predicate = getFilterPredicate(searchCriteria, root);
    cq.where(predicate);
    TypedQuery<Advertisement> query = entityManager.createQuery(cq);
    return query.getResultList();
  }

  private Predicate getFilterPredicate(AdvertisementSearchCriteria searchCriteria, Root<Advertisement> root) {

    List<Predicate> predicates = new ArrayList<>();

    if (searchCriteria.getId() != null) {
      Join<Advertisement, Item> itemJoin = root.join("item");
      predicates.add(criteriaBuilder.equal(itemJoin.get("id"), searchCriteria.getId()));
    }

    if (searchCriteria.getColor() != null) {
      Join<Advertisement, Color> colorJoin = root.join("color");
      predicates.add(
        criteriaBuilder.
          equal(criteriaBuilder.lower(colorJoin.get("color")), searchCriteria.getColor().toLowerCase()));
    }
    if (searchCriteria.getWeight() != null) {
      Join<Advertisement, Mass> massJoin = root.join("mass");
      predicates.add(criteriaBuilder.equal(massJoin.<Integer>get("weight"), searchCriteria.getWeight())
      );
    }
    if (searchCriteria.getVolume() != null) {
      Join<Advertisement, Volume> volumeJoin = root.join("volume");
      predicates.add(criteriaBuilder.equal(volumeJoin.<Integer>get("volume"), searchCriteria.getVolume()));
    }

    if (searchCriteria.getLength() != null) {
      Join<Advertisement, Dimension> dimensionJoin = root.join("dimension");
      predicates.add(criteriaBuilder.equal(dimensionJoin.<Integer>get("length"), searchCriteria.getLength()));
    }
    if (searchCriteria.getWidth() != null) {
      Join<Advertisement, Dimension> dimensionJoin = root.join("dimension");
      predicates.add(criteriaBuilder.equal(dimensionJoin.<Integer>get("width"), searchCriteria.getWidth()));
    }
    if (searchCriteria.getHeight() != null) {
      Join<Advertisement, Dimension> dimensionJoin = root.join("dimension");
      predicates.add(criteriaBuilder.equal(dimensionJoin.<Integer>get("height"), searchCriteria.getHeight()));
    }
    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }
}

