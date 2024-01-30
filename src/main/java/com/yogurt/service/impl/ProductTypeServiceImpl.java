package com.yogurt.service.impl;

import com.yogurt.dto.ProductTypeDto;
import com.yogurt.repository.ProductTypeRepo;
import com.yogurt.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {
    ProductTypeRepo productTypeRepo;
    ModelMapper modelMapper;
    @Override
    public List<ProductTypeDto> findAll() {
        return productTypeRepo.findAll()
                .stream()
                .map(productType ->modelMapper.map(productType, ProductTypeDto.class))
                .collect(Collectors.toList());
    }
}
