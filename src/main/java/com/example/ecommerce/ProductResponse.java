package com.example.ecommerce;

import java.util.List;

public class ProductResponse {
	private List<ProductResponseItem> productResponseItems;

	public ProductResponse(){

	}

	public ProductResponse(List<ProductResponseItem> productResponseItems){
		this.productResponseItems = productResponseItems;
	}

	public void setProductResponse(List<ProductResponseItem> productResponseItems){
		this.productResponseItems = productResponseItems;
	}

	public List<ProductResponseItem> getProductResponse(){
		return productResponseItems;
	}
}