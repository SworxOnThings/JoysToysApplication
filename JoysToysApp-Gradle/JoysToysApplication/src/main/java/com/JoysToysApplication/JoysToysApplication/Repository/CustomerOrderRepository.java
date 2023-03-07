package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrder;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Override
    Optional<CustomerOrder> findById(@Nonnull Long aLong);

    @Override
    List<CustomerOrder> findAllById(@Nonnull Iterable<Long> longs);
}
