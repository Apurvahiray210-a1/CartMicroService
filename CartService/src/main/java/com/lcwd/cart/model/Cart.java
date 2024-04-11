package com.lcwd.cart.model;

import java.util.Date;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shopping_Cartt")
public class Cart {

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this. totalPrice = quantity *price;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
    private String productId;
    private double totalPrice;
    private int quantity;
    private double price;
	//private Product product;
	//private List<Cart>cartItems;
	

}
