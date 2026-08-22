package com.chhetriSom.billingSoftware.repository;

import com.chhetriSom.billingSoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {
}
