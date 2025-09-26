package com.SpringFromScratch.shoppingcart.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String messaage;
    private Object data;
}
