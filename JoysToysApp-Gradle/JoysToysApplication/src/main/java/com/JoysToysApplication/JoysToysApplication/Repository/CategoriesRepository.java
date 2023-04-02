package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.Categories;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    @Override
    Optional<Categories> findById(@Nonnull Long aLong);

    @Override
    List<Categories> findAllById(@Nonnull Iterable<Long> longs);
}
