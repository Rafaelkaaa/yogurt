package com.yogurt.repository;

import com.yogurt.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductTypeRepo extends JpaRepository<ProductType, UUID> {}
