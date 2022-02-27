package com.example.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ProductResponseItemRepository extends JpaRepository<ProductResponseItem, Integer> {

    Optional<List<ProductResponseItem>> findByNameContainingIgnoreCase(String name);
}
