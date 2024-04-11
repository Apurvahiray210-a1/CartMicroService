package com.lcwd.cart.service;

import java.util.List;

import com.lcwd.cart.model.Cart;

public interface CartService {
  //Cart addProductToCart(Cart cart);

//Cart addProductToCart(String productId, int cartId);

Cart addProductToCart(Cart cart);


 public List<Cart> getAllProductInCart();
 
 public String deleteProductFromCart(String cartId);
 
  public void updateCart(String cartId,String productId,int quantity);
 
}