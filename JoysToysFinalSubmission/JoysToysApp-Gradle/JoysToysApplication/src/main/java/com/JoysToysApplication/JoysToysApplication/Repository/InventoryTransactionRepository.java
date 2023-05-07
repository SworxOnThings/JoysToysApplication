package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.InventoryTransaction;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {
    @Override
    Optional<InventoryTransaction> findById(@Nonnull Long aLong);

    @Override
    List<InventoryTransaction> findAllById(@Nonnull Iterable<Long> longs);
}
