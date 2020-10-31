package com.spolyzon.house.review.domain.repository;

import com.spolyzon.house.review.domain.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
