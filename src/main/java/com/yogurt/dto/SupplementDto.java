package com.yogurt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplementDto {
    private String id;
    private String name;
    private int weight;
    private String image;
    private String type;
}
