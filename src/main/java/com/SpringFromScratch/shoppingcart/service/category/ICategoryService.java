package com.SpringFromScratch.shoppingcart.service.category;

import com.SpringFromScratch.shoppingcart.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    void deleteCategoryById(Category category);
    Category updateCategory(Category category, Long id);
}
