package com.yogurt.controller;

import com.yogurt.dto.CardVO;
import com.yogurt.service.CardService;
import com.yogurt.service.ProductService;
import com.yogurt.service.SupplementService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/supplement")
public class SupplementController {
    SupplementService supplementService;
    ProductService productService;
    CardService cardService;

    @GetMapping("/{productId}")
    public String findAll(@PathVariable String productId,
                          @RequestParam(required = false) @Nullable String cardId,
                          Model model) {
        model.addAttribute("supplements", supplementService.findAll());
        model.addAttribute("product", productService.findById(productId));
        if (cardId==null) cardId = cardService.save();
        model.addAttribute("cardVO", new CardVO(cardId, productId));
        return "/supplement/supplement_all";
    }

    @PostMapping("/add/{productId}/{supplementId}")
    public String addSupplementToProduct(@PathVariable String productId,
                                         @PathVariable String supplementId) {
        productService.addSupplementToProduct(productId, supplementId);
        return "redirect:/supplement/" + productId;
    }

    @PostMapping("/delete/{productId}/{supplementId}")
    public String removeSupplementToProduct(@PathVariable String productId,
                                            @PathVariable String supplementId) {
        productService.removeSupplementFromProduct(productId, supplementId);
        return "redirect:/supplement/" + productId;
    }
}
