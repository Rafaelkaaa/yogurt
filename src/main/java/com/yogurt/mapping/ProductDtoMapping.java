package com.yogurt.mapping;

import com.yogurt.dto.ProductDto;
import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.product.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;
@AllArgsConstructor
public class ProductDtoMapping extends AbstractConverter<Product, ProductDto> {
    ModelMapper modelMapper;

    @Override
    protected ProductDto convert(Product product) {
        return ProductDto.builder()
                .id(product.getId().toString())
                .productType(product.getProductType().name())
                .supplements(product.getSupplements()
                        .stream()
                        .map(supplement -> modelMapper.map(supplement, SupplementDto.class))
                        .collect(Collectors.toList()))
                .build();
    }
}
