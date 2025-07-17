package com.talentotech.final_ecommerce.dto.response;

import com.talentotech.final_ecommerce.dto.CategoryDTO;

import java.util.List;

public class CategoryResponseDTO extends ResponseDTO {
    List<CategoryDTO> c;
    public CategoryResponseDTO(String message, List<CategoryDTO> c) {
        super(message);
        this.c = c;
    }
}
