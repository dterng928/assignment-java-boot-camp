package com.example.ecommerce;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductResponseItem {
	@Id
	private Integer id;
	private Double price;
	private String name;

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

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}
}
