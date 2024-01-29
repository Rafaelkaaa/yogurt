package com.yogurt.service.impl;

import com.yogurt.dto.ProductDto;
import com.yogurt.entity.product.Product;
import com.yogurt.entity.supplements.Supplement;
import com.yogurt.exception.ErrorMessage;
import com.yogurt.exception.NotFoundException;
import com.yogurt.repository.ProductRepo;
import com.yogurt.repository.SupplementRepo;
import com.yogurt.service.ProductService;
import com.yogurt.service.SupplementProcessor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepo productRepo;
    SupplementRepo supplementRepo;
    ModelMapper modelMapper;

    @Override
    public void addSupplementToProduct(String productId, String supplementId) {
        SupplementProcessor processor = (product, supplement) -> product.getSupplements().add(supplement);
        processProduct(productId, supplementId, processor);
    }

    @Override
    public void removeSupplementFromProduct(String productId, String supplementId) {
        SupplementProcessor processor = (product, supplement) -> product.getSupplements().remove(supplement);
        processProduct(productId, supplementId, processor);
    }

    @Override
    public ProductDto findById(String id) {
        Optional<Product> product = productRepo.findById(UUID.fromString(id));
        if (product.isPresent()){
            return modelMapper.map(product, ProductDto.class);
        }
        throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_ID + id);
    }

    @Override
    public void save(ProductDto product) {
        productRepo.save(modelMapper.map(product, Product.class));
    }

    private void processProduct(String productId, String supplementId, SupplementProcessor processor) {
        Optional<Product> product = productRepo.findById(UUID.fromString(productId));
        Optional<Supplement> supplement = supplementRepo.findById(UUID.fromString(supplementId));
        if (product.isPresent() && supplement.isPresent()) {
            processor.process(product.get(), supplement.get());
            productRepo.save(product.get());
        }
    }
}
