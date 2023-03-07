package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.PaymentInformation;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The repository is where the SQL code is used. These functions generate the desired SQL statements "auto-magically"
 */
public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Long> {

    @Override
    Optional<PaymentInformation> findById(@Nonnull Long aLong);

    @Override
    List<PaymentInformation> findAllById(@Nonnull Iterable<Long> longs);
}
