package com.JoysToysApplication.JoysToysApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * This accesses the databases. You can use the functions declared here to find/delete/do specific stuff from/to your database. The functions are implemented by JpaRepository.
 */
public interface CustomerRepository extends JpaRepository <Customer, Long>{
    @Override
    Optional<Customer> findById(@NonNull Long aLong);

    @Override
    List<Customer> findAllById(@NonNull Iterable<Long> longs);
}
