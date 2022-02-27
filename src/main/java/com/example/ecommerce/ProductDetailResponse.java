package com.example.ecommerce;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDetailResponse{
	@Id
	private int id;
	private Double price;
	private String name;
	private String sku;
	private String brand;
	private String status;

	public ProductDetailResponse() {

	}

	public ProductDetailResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPrice(Double price){
		this.price = price;
	}

	public Double getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}
}
