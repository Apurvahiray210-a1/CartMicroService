package com.lcwd.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,String> {

}
