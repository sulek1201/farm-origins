package com.sulek.farmorigins.repository.parameter;

import com.sulek.farmorigins.entity.parameter.Category;
import com.sulek.farmorigins.entity.parameter.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {
}
