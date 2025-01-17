package com.example.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductResponseItemRepository productResponseItemRepository;

    @MockBean
    private ProductDetailResponseRespository productDetailResponseRespository;

    @Test
    void positiveGetProductListByName() {
        List<ProductResponseItem> productItemList = new ArrayList<ProductResponseItem>();
        ProductResponseItem productItemA = new ProductResponseItem();
        productItemA.setId(1);
        productItemA.setPrice(95.0);
        productItemA.setName("Flowflex 2:1");
        productItemList.add(productItemA);

        ProductResponseItem productItemB = new ProductResponseItem();
        productItemB.setId(2);
        productItemB.setPrice(1350.0);
        productItemB.setName("Set 10 Flowflex");
        productItemList.add(productItemB);

        ProductResponseItem productItemC = new ProductResponseItem();
        productItemC.setId(3);
        productItemC.setPrice(650.0);
        productItemC.setName("Set 10 Flowflex");
        productItemList.add(productItemC);

        when(productResponseItemRepository.findByNameContainingIgnoreCase("Flowflex")).thenReturn(Optional.of(productItemList));

        ProductResponse result = testRestTemplate.getForObject("/productlist/Flowflex", ProductResponse.class);

        assertEquals(3, result.getProductResponse().size());
    }

    @Test
    void negativeGetProductListByName() {
        List<ProductResponseItem> productItemList = new ArrayList<ProductResponseItem>();

        when(productResponseItemRepository.findByNameContainingIgnoreCase("NotFound")).thenReturn(Optional.of(productItemList));

        ProductResponse result = testRestTemplate.getForObject("/productlist/NotFound", ProductResponse.class);

        assertEquals(0, result.getProductResponse().size());
    }

    @Test
    void positiveGetProductsById() {
        ProductDetailResponse productDetail = new ProductDetailResponse();
        productDetail.setId(1);
        productDetail.setPrice(95.0);
        productDetail.setBrand("flowflex");
        productDetail.setName("Flowflex 2:1");
        productDetail.setSku("3438825297_TH-11111021111");

        when(productDetailResponseRespository.findById(1)).thenReturn(Optional.of(productDetail));

        ProductDetailResponse result = testRestTemplate.getForObject("/product/1", ProductDetailResponse.class);

        assertEquals("SUCCESS", result.getStatus());
    }

    @Test
    void negativeGetProductsById() {
        ProductDetailResponse productDetail = new ProductDetailResponse("ERROR");
        when(productDetailResponseRespository.findById(1)).thenReturn(Optional.of(productDetail));

        ProductDetailResponse result = testRestTemplate.getForObject("/product/2", ProductDetailResponse.class);

        assertEquals("ERROR", result.getStatus());
    }
}

