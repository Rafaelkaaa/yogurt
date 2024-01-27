package com.yogurt.repository;

import com.yogurt.entity.supplements.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SupplementRepo extends JpaRepository<Supplement, UUID> {}
