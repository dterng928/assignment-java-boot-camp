package com.example.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDetailResponseRespository extends JpaRepository<ProductDetailResponse, Integer> {

    Optional<ProductDetailResponse> findById(Integer Id);
}
