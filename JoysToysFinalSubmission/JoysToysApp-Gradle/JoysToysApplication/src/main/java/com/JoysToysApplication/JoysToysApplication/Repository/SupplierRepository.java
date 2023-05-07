package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.Supplier;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Override
    Optional<Supplier> findById(@Nonnull Long aLong);

    @Override
    List<Supplier> findAllById(@Nonnull Iterable<Long> longs);
}
