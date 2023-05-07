package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.InventoryOrder;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryOrderRepository extends JpaRepository<InventoryOrder, Long> {

    @Override
    Optional<InventoryOrder> findById(@Nonnull Long aLong);

    @Override
    List<InventoryOrder> findAllById(@Nonnull Iterable<Long> longs);
}
