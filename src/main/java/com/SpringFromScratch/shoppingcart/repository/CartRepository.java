package com.SpringFromScratch.shoppingcart.repository;

import com.SpringFromScratch.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
