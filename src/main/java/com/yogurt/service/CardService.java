package com.yogurt.service;

import com.yogurt.dto.ProductDto;

public interface CardService {
    void save(ProductDto product);
    void addProductToCard(String cardId, String productId);
    void removeProductFromCard(String cardId, String productId);
}
