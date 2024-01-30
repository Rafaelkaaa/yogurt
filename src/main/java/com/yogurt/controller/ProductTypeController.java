package com.yogurt.controller;

import com.yogurt.service.CardService;
import com.yogurt.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/product_type")
public class ProductTypeController {
    ProductTypeService productTypeService;
    CardService cardService;

    @GetMapping()
    public String findAll(@RequestParam(required = false) String cardId,
                          Model model) {
        model.addAttribute("productTypes", productTypeService.findAll());
        if (cardId == null) {cardId = cardService.save();}
        model.addAttribute("cardId", cardId);
        return "/customers/product/all";
    }
}
