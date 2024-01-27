package com.yogurt.service;

import com.yogurt.dto.ProductDto;

public interface ProductService {
    void addSupplementToProduct(String productId, String supplementId);
    void removeSupplementFromProduct(String productId, String supplementId);
    ProductDto findById(String id);
    void save(ProductDto product);
}
