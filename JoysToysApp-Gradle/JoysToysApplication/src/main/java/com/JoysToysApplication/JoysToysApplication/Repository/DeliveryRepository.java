package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.Delivery;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Override
    Optional<Delivery> findById(@Nonnull Long aLong);

    @Override
    List<Delivery> findAllById(@Nonnull Iterable<Long> longs);
}
