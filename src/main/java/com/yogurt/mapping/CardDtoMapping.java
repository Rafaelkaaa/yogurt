package com.yogurt.mapping;

import com.yogurt.dto.CardDto;
import com.yogurt.dto.ProductDto;
import com.yogurt.entity.Card;
import lombok.AllArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

@AllArgsConstructor
public class CardDtoMapping extends AbstractConverter<Card, CardDto> {
    ModelMapper modelMapper;
    @Override
    protected CardDto convert(Card card) {
        return CardDto.builder()
                .id(card.getId().toString())
                .cost(card.getCost().toString())
                .products(card.getProducts()
                        .stream()
                        .map(product ->modelMapper.map(product, ProductDto.class))
                        .collect(Collectors.toList()))
                .build();
    }
}
