package com.yogurt.repository;

import com.yogurt.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {}
