package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/productlist/{name}")
    public ProductResponse getProductsByName(@PathVariable String name) {
        return new ProductResponse(productsService.queryProductListByName(name));
    }
}
