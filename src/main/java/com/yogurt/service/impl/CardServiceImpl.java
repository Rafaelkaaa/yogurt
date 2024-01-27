package com.yogurt.service.impl;

import com.yogurt.dto.ProductDto;
import com.yogurt.entity.Card;
import com.yogurt.entity.product.Product;
import com.yogurt.repository.CardRepo;
import com.yogurt.repository.ProductRepo;
import com.yogurt.service.CardProcessor;
import com.yogurt.service.CardService;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

public class CardServiceImpl implements CardService {
    private CardRepo cardRepo;
    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    @Override
    public void save(ProductDto product) {
        cardRepo.save(Card.builder()
                .product(Collections.singleton(modelMapper.map(product, Product.class)))
                .cost(new BigDecimal(product.getCost()))
                .amount(1L)
                .build());
    }

    @Override
    public void addProductToCard(String cardId, String productId) {

    }

    @Override
    public void removeProductFromCard(String cardId, String productId) {

    }

    private void processCard(String productId, String supplementId, CardProcessor processor) {
        Optional<Card> card = cardRepo.findById(UUID.fromString(productId));
        Optional<Product> product = productRepo.findById(UUID.fromString(supplementId));
        if (card.isPresent() && product.isPresent()) {
            processor.process(card.get(), product.get());
            productRepo.save(product.get());
        }
    }
}
