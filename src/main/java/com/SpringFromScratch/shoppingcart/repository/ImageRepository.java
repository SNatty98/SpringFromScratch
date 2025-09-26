package com.SpringFromScratch.shoppingcart.repository;

import com.SpringFromScratch.shoppingcart.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
