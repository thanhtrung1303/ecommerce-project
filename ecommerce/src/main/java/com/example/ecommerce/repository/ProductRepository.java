package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    int countByBrandId(int id);

    Page<Product> findProductByNameContaining(String keyword, Pageable pageable);

    Page<Product> getAllByCategories_Id(int id, Pageable pageable);

    Page<Product> getAllByBrand_Id(int id, Pageable pageable);

    @Query(nativeQuery = true, name = "getListProductLimit")
    List<Product> getListProductLimit(int limit);

    @Query("SELECT p from Product p WHERE p.price < 2000000")
    Page<Product> getProductsList1(Pageable pageable);

    @Query("SELECT p from Product p WHERE p.price > 2000000 and p.price < 6000000")
    Page<Product> getProductsList2(Pageable pageable);

    @Query("SELECT p from Product p WHERE p.price > 6000000 and p.price < 10000000")
    Page<Product> getProductsList3(Pageable pageable);

    @Query("SELECT p from Product p WHERE p.price > 10000000")
    Page<Product> getProductsList4(Pageable pageable);

}
