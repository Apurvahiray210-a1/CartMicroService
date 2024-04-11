package com.lcwd.cart.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.cart.exception.ResourceNotFoundException;
import com.lcwd.cart.model.Cart;
import com.lcwd.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
	private CartRepository cartRepository;
	
	
	private Logger logger=LoggerFactory.getLogger(CartServiceImpl .class);
	@Override
	public Cart addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}
/*
	
	public void addToCart(String productId,int cartId) {
		ResponseEntity<Product>productResponse=restTemplate.getForEntity("http://8080/product/{productId}", Product.class, productId);
	   Product product=productResponse.getBody();
	   Cart cart=new Cart();
	   //Cart cart1 = retrieveShoppingCartFromAnotherMicroservice(cartId);

       // Add the fetched product to the shopping cart
       cart.setProduct(product);

       // Update the shopping cart in your microservice
       updateShoppingCartInYourMicroservice(cart);
   }

	  public void updateShoppingCartInYourMicroservice(Cart cart) {
	        // Fetch the existing shopping cart from the repository
	        Cart existingCart = cartRepo.findById(cart.getCartId()).orElse(null);

	        if (existingCart != null) {
	            // Update the existing cart with the new data
	            existingCart.setCartItems(cart.getCartItems()); // Assuming Cart has a method to set items

	            // Save the updated shopping cart
	            cartRepo.save(existingCart);
	        } else {
	        	System.out.println("Car is empty");
	            // Handle error: cart not found
	            // You can choose to throw an exception, log an error, or handle it in another way
	        }
	    }

*/

	@Override
	public List<Cart> getAllProductInCart() {
		
		return cartRepository.findAll();
	}
	
	public String deleteProductFromCart(String cartId) {
		///Cart cart=cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", cartId));;;
		Cart cart=cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", cartId));
		if(cart!=null) {
			cartRepository.deleteById(cartId);
			return "Product Deleted Successfully";
		}
		return "Something wrong on server";
		}
	
	
	public void updateCart(String cartId, String productId, int quantity) {
	    Optional<Cart> optionalCart = cartRepository.findById(cartId);
	    if (optionalCart.isPresent()) {
	        Cart cart = optionalCart.get();
	        if (cart.getProductId().equals(productId)) {
	            cart.setQuantity(quantity);
	            
	            
	            cartRepository.save(cart);
	            logger.info("Cart updated successfully");
	        } else {
	            throw new ResourceNotFoundException("Cart", "ProductId", productId);
	        }
	    } else {
	        throw new ResourceNotFoundException("Cart", "CartId", cartId);
	    }
	}
	
	}
	

	
	
	
	

