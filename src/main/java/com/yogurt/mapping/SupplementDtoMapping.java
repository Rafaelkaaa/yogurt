package com.yogurt.mapping;

import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.supplements.Supplement;
import org.modelmapper.AbstractConverter;

public class SupplementDtoMapping extends AbstractConverter<Supplement, SupplementDto> {

    @Override
    protected SupplementDto convert(Supplement supplement) {
        return SupplementDto.builder()
                .id(supplement.getId().toString())
                .name(supplement.getName())
                .weight(supplement.getWeight())
                .image(supplement.getImage())
                .type(supplement.getType().name())
                .build();
    }
}
