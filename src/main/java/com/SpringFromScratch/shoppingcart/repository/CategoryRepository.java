package com.SpringFromScratch.shoppingcart.repository;

import com.SpringFromScratch.shoppingcart.model.Category;
import com.SpringFromScratch.shoppingcart.requests.AddProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
