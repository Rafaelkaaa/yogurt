package com.yogurt.service;

import com.yogurt.dto.ProductTypeDto;

import java.util.List;

public interface ProductTypeService {
    List<ProductTypeDto> findAll();
    void save(ProductTypeDto productTypeDto);
}
