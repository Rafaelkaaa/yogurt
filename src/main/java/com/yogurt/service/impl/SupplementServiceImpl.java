package com.yogurt.service.impl;

import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.supplements.Supplement;
import com.yogurt.exception.ErrorMessage;
import com.yogurt.exception.NotFoundException;
import com.yogurt.repository.SupplementRepo;
import com.yogurt.service.SupplementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplementServiceImpl implements SupplementService {
    private SupplementRepo supplementRepo;
    private ModelMapper modelMapper;

    @Override
    public SupplementDto findById(String id) {
        Optional<Supplement> supplement = supplementRepo.findById(UUID.fromString(id));
        if (supplement.isEmpty()) throw new NotFoundException(ErrorMessage.SUPPLEMENT_NOT_FOUND_BY_ID + id);
        return modelMapper.map(supplement.get(), SupplementDto.class);
    }

    @Override
    public Supplement findById(UUID id) {
        return supplementRepo.findById(id).get();
    }

    @Override
    public List<SupplementDto> findAll() {
        return supplementRepo.findAll()
                .stream()
                .map(supplement -> modelMapper.map(supplement, SupplementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<SupplementDto> findAll(Pageable pageable) {
        return supplementRepo.findAll(pageable)
                .map(supplement -> modelMapper.map(supplement, SupplementDto.class));
    }
}
