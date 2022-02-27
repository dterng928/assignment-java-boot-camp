package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductResponseItemRepository productResponseItemRepository;

    public List<ProductResponseItem> queryProductListByName(String name){
        return productResponseItemRepository.findByNameContainingIgnoreCase(name).get();
    }
}
