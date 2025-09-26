package com.SpringFromScratch.shoppingcart.service.image;

import com.SpringFromScratch.shoppingcart.dto.ImageDto;
import com.SpringFromScratch.shoppingcart.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
