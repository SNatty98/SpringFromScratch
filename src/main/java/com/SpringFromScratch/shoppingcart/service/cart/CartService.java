package com.SpringFromScratch.shoppingcart.service.cart;

import com.SpringFromScratch.shoppingcart.exceptions.ResourceNotFoundException;
import com.SpringFromScratch.shoppingcart.model.Cart;
import com.SpringFromScratch.shoppingcart.model.CartItem;
import com.SpringFromScratch.shoppingcart.repository.CartItemRepository;
import com.SpringFromScratch.shoppingcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService implements  ICartService{
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllById(id);
        cart.getCartItemSet().clear();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getCartItemSet().stream()
                .map(CartItem::getTotalPrice) // Extract each items totalPrice
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Sum them
    }
}
