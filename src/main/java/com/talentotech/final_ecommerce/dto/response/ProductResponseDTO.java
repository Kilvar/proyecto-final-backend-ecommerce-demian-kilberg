package com.talentotech.final_ecommerce.dto.response;

import com.talentotech.final_ecommerce.dto.ProductDTO;

import java.util.List;

public class ProductResponseDTO extends ResponseDTO {

    ProductDTO dto;
    public ProductResponseDTO(String message, ProductDTO dto) {
        super(message);
        this.dto = dto;
    }
}
