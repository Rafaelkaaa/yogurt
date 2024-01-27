package com.yogurt.service;

import com.yogurt.entity.product.Product;
import com.yogurt.entity.supplements.Supplement;

@FunctionalInterface
public interface SupplementProcessor {
    void process(Product product, Supplement supplement);
}
