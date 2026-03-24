package com.storemanagement.repository;

import com.storemanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrCompanyContainingIgnoreCase(
            String name, String category, String company
    );
}
