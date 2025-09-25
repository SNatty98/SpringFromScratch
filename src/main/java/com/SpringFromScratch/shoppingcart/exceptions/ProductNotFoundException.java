package com.SpringFromScratch.shoppingcart.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException (String productNotFound) {
        super(productNotFound);
    }
}
