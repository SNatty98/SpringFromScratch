package com.SpringFromScratch.shoppingcart.controllers;

import com.SpringFromScratch.shoppingcart.exceptions.ResourceNotFoundException;
import com.SpringFromScratch.shoppingcart.model.Product;
import com.SpringFromScratch.shoppingcart.requests.AddProductRequest;
import com.SpringFromScratch.shoppingcart.requests.UpdateProductRequest;
import com.SpringFromScratch.shoppingcart.response.ApiResponse;
import com.SpringFromScratch.shoppingcart.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        try {
            List<Product> responseProducts = productService.getAllProducts();

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found", null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId) {
        try {
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Product found", product));

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<ApiResponse> getProductsByName(@PathVariable String name) {
        try {
            List<Product> responseProducts = productService.getProductsByName(name);

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found for name: " + name, null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/{category}")
    public ResponseEntity<ApiResponse> getProductsByCategory(@PathVariable String category) {
        try {
            List<Product> responseProducts = productService.getProductsByCategory(category);

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found for category: " + category, null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/brand")
    public ResponseEntity<ApiResponse> getProductsByBrand(@RequestParam String brand) {
        try {
            List<Product> responseProducts = productService.getProductsByBrand(brand);

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found for brand: " + brand, null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/category-and-brand")
    public ResponseEntity<ApiResponse> getProductsByCategoryAndBrand(@RequestParam String category, @RequestParam String brand) {
        try {
            List<Product> responseProducts = productService.getProductsByCategoryAndBrand(category, brand);

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found for category: " + category + " and brand: " + brand + " combination", null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/brand-and-name")
    public ResponseEntity<ApiResponse> getProductsByBrandAndName(@RequestParam String brand, @RequestParam String name) {
        try {
            List<Product> responseProducts = productService.getProductsByBrandAndName(brand, name);

            if(responseProducts.isEmpty())
                return ResponseEntity.status(NOT_FOUND)
                        .body(new ApiResponse("No products found for brand: " + brand + " and name: " + name + " combination", null));

            return ResponseEntity.ok(new ApiResponse("Products found", responseProducts));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/count-brand-name")
    public ResponseEntity<ApiResponse> countProductsByBrandAndName(@RequestParam String brand, @RequestParam String name) {
        try {
            var productCount = productService.countProductsByBrandAndName(brand, name);
            return ResponseEntity.ok(new ApiResponse("Number of products found: " + productCount, productCount));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {
        try {
            Product addedProduct = productService.addProduct(product);
            return ResponseEntity.ok(new ApiResponse("Product added", addedProduct));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody UpdateProductRequest request, @PathVariable Long productId) {
        try {
            Product product = productService.updateProduct(request, productId);
            return ResponseEntity.ok(new ApiResponse("Product updated", product));

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), NOT_FOUND));
        }
    }

    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Product: " + productId + " deleted", null));

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), NOT_FOUND));
        }
    }
}
