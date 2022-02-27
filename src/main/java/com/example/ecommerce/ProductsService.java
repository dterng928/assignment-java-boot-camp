package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductResponseItemRepository productResponseItemRepository;

    @Autowired
    private ProductDetailResponseRespository productDetailResponseRespository;

    public List<ProductResponseItem> queryProductListByName(String name){
        return productResponseItemRepository.findByNameContainingIgnoreCase(name).get();
    }

    public ProductDetailResponse queryProductById(Integer id){
        Optional<ProductDetailResponse> result = productDetailResponseRespository.findById(id);
        if(result.isPresent()){
            result.get().setStatus("SUCCESS");
            return result.get();
        }
        return new ProductDetailResponse("ERROR");
    }
}
