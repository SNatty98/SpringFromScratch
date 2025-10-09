package com.SpringFromScratch.shoppingcart.repository;

import com.SpringFromScratch.shoppingcart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllById(Long id);
}
