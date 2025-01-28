package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

	@Id
	@Min(value = 1, message = "Product ID must be greater than 0")
	private int productId;

	@NotBlank(message = "Product name is mandatory")
	private String productName;

	@Min(value = 0, message = "Product price must be non-negative")
	private int productPrice;

	@NotBlank(message = "Product category is mandatory")
	private String productCategory;

	@NotNull(message = "Product validity date is mandatory")
	
	private Date productValidity;

	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	@JsonBackReference
	private Cart cart;

}
