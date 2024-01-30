package com.yogurt.mapping;

import com.yogurt.dto.ProductTypeDto;
import com.yogurt.entity.product.ProductType;
import org.modelmapper.AbstractConverter;

public class ProductTypeDtoMapping extends AbstractConverter<ProductType, ProductTypeDto> {
    @Override
    protected ProductTypeDto convert(ProductType productType) {
        return ProductTypeDto.builder()
                .id(productType.getId().toString())
                .name(productType.getName())
                .cost(productType.getCost().toString())
                .build();
    }
}
