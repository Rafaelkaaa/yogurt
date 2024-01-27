package com.yogurt.repository;

import com.yogurt.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {}
