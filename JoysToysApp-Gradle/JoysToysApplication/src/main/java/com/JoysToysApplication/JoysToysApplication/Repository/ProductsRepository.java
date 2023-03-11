package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.Products;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository <Products, Long>{

    @Override
    Optional<Products> findById(@NonNull Long aLong);

    @Override
    List<Products> findAllById(@Nonnull Iterable<Long> longs);
}
