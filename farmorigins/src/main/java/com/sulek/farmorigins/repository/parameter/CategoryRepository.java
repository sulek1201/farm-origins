package com.sulek.farmorigins.repository.parameter;

import com.sulek.farmorigins.entity.Store;
import com.sulek.farmorigins.entity.parameter.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
