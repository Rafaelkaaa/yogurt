package com.yogurt.controller;

import com.yogurt.service.CardService;
import com.yogurt.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {
    ProductService productService;
    CardService cardService;

    @PostMapping("/{typeId}")
    public String createProduct(@PathVariable String typeId,
                                @RequestParam String cardId) {
        String productId = productService.save(typeId);
        return "redirect:/supplement/" + productId + "?cardId=" + cardId;
    }
}

