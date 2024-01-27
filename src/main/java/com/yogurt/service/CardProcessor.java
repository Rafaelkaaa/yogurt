package com.yogurt.service;

import com.yogurt.entity.Card;
import com.yogurt.entity.product.Product;

@FunctionalInterface
public interface CardProcessor {
    void process(Card card, Product product);
}
