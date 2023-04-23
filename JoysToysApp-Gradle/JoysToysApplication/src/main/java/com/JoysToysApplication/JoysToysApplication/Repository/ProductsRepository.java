package com.JoysToysApplication.JoysToysApplication.Repository;

import com.JoysToysApplication.JoysToysApplication.Entity.Categories;
import com.JoysToysApplication.JoysToysApplication.Entity.Products;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository <Products, Long>{

    @Override
    Optional<Products> findById(@NonNull Long aLong);

    @Override
    List<Products> findAllById(@Nonnull Iterable<Long> longs);

    // :CategoryName is called a Named Parameter
  //@Query("SELECT p.product_id, p.product_name, p.price, p.product_stock, p.imageurl, p.category FROM public.products p inner join public.categories c on p.category = c.category_id where c.category_name = :CategoryName")
    List<Products> findByCategoryCategoryName(String categoryName);
}
