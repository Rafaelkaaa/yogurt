package com.yogurt.service;

import com.yogurt.dto.CardDto;
import com.yogurt.dto.CardVO;
import com.yogurt.dto.ProductDto;
import com.yogurt.entity.product.Product;

public interface CardService {
    String save();
    void addProductToCard(CardVO cardVO);
    void removeProductFromCard(String cardId, String productId);
    CardDto findById(String id);
}
