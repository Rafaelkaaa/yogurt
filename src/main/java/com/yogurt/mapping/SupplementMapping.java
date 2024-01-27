package com.yogurt.mapping;

import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.supplements.Supplement;
import com.yogurt.entity.supplements.SupplementType;
import com.yogurt.service.SupplementService;
import lombok.AllArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class SupplementMapping extends AbstractConverter<SupplementDto, Supplement> {
    SupplementService supplementService;

    @Override
    protected Supplement convert(SupplementDto supplementDto) {
        Supplement supplement = Supplement.builder()
                .name(supplementDto.getName())
                .weight(supplementDto.getWeight())
                .image(supplementDto.getImage())
                .type(SupplementType.valueOf(supplementDto.getType()))
                .build();
        supplement.setId(UUID.fromString(supplementDto.getId()));
        return supplement;
    }
}
