package com.SpringFromScratch.shoppingcart.service.cart;

import com.SpringFromScratch.shoppingcart.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
}
