package com.yogurt.service;

import com.yogurt.dto.CardDto;
import com.yogurt.dto.CardVO;

public interface CardService {
    String save();
    void addProductToCard(CardVO cardVO);
    void removeProductFromCard(CardVO cardVO);
    CardDto findById(String id);
}
