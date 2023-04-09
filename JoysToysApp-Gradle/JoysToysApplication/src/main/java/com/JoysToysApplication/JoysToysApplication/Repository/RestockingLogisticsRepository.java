package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.RestockingLogistics;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestockingLogisticsRepository extends JpaRepository<RestockingLogistics, Long>{

    @Override
    Optional<RestockingLogistics> findById(@Nonnull Long aLong);

    @Override
    List<RestockingLogistics> findAllById(@Nonnull Iterable<Long> longs);
}
