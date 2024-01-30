package com.yogurt.service;

import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.supplements.Supplement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SupplementService {
    SupplementDto findById(String id);

    Supplement findById(UUID id);

    List<SupplementDto> findAll();
    Page<SupplementDto> findAll(Pageable pageable);
    void save(SupplementDto supplementDto);
}
