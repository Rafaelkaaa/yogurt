package com.yogurt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    String id;
    ProductTypeDto productType;
    List<SupplementDto> supplements;
}
