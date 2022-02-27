package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private ProductResponseItemRepository productResponseItemRepository;

	@Autowired
	private ProductDetailResponseRespository productDetailResponseRespository;

	@PostConstruct
	public void generateData() {
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

		productResponseItemRepository.saveAll(productItemList);

		ProductDetailResponse productDetail = new ProductDetailResponse();
		productDetail.setId(1);
		productDetail.setPrice(95.0);
		productDetail.setBrand("flowflex");
		productDetail.setName("Flowflex 2:1");
		productDetail.setSku("3438825297_TH-11111021111");

		productDetailResponseRespository.save(productDetail);
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
