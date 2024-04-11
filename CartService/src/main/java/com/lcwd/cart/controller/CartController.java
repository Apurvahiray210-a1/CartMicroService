package com.lcwd.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.cart.model.Cart;
import com.lcwd.cart.service.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;
	@PostMapping("/addToCart")
	public Cart addProductToCart(@RequestBody Cart cart) {
		return cartService.addProductToCart(cart);
		
	}
	
	@GetMapping("/getAllProductsInCart")
    public List<Cart> getAllProductsInCart() {
        return cartService.getAllProductInCart();
    }
	
	@DeleteMapping("/deleteProductFromCart/{cartId}")
    public String deleteProductFromCart(@PathVariable String cartId) {
        return cartService.deleteProductFromCart(cartId);
    }
	

    @PutMapping("/updateCart/{cartId}/{productId}/{quantity}")
    public void updateCart(@PathVariable String cartId,
                           @PathVariable String productId,
                           @PathVariable int quantity) {
        cartService.updateCart(cartId, productId, quantity);
    }
}
