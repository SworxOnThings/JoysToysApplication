package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerTransaction;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long> {

    @Override
    Optional<CustomerTransaction> findById(@Nonnull Long aLong);

    @Override
    List<CustomerTransaction> findAllById(@Nonnull Iterable<Long> longs);
}
