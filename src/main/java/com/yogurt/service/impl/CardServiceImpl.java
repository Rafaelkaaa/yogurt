package com.yogurt.service.impl;

import com.yogurt.dto.CardDto;
import com.yogurt.dto.CardVO;
import com.yogurt.entity.Card;
import com.yogurt.entity.product.Product;
import com.yogurt.exception.ErrorMessage;
import com.yogurt.exception.NotFoundException;
import com.yogurt.repository.CardRepo;
import com.yogurt.repository.ProductRepo;
import com.yogurt.service.CardProcessor;
import com.yogurt.service.CardService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private CardRepo cardRepo;
    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    @Override
    public String save() {
        String cardId = cardRepo.save(Card.builder()
                        .cost(new BigDecimal(0))
                .build()).getId().toString();
        return cardId;
    }

    @Override
    public CardDto findById(String id) {
        Optional<Card> card = cardRepo.findById(UUID.fromString(id));
        if (card.isPresent()){
            return modelMapper.map(card, CardDto.class);
        }
        throw new NotFoundException(ErrorMessage.CARD_NOT_FOUND_BY_ID + id);
    }

    @Override
    public void addProductToCard(CardVO cardVO) {
            CardProcessor processor = (card, product) -> {
                card.getProducts().add(product);
            card.setCost(card.getCost().add(product.getCost()));
            };
            processCard(cardVO.getCardId(), cardVO.getProductId(), processor);
    }

    @Override
    public void removeProductFromCard(String cardId, String productId) {
        CardProcessor processor = (card,product) -> {
            card.getProducts().remove(product);
            card.setCost(card.getCost().subtract(product.getCost()));
        };
        processCard(cardId, productId, processor);
    }

    private void processCard(String productId, String supplementId, CardProcessor processor) {
        Optional<Card> card = cardRepo.findById(UUID.fromString(productId));
        Optional<Product> product = productRepo.findById(UUID.fromString(supplementId));
        if (card.isPresent() && product.isPresent()) {
            processor.process(card.get(), product.get());
            productRepo.save(product.get());
        }
    }
}
