package com.yogurt.controller;

import com.yogurt.service.ProductService;
import com.yogurt.service.SupplementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/supplement")
public class SupplementController {
    SupplementService supplementService;
    ProductService productService;

    @GetMapping("/{productId}")
    public String findAll(@PathVariable String productId,
                          Model model) {
        model.addAttribute("supplements", supplementService.findAll());
        model.addAttribute("product", productService.findById(productId));
        return "/supplement/supplement_all";
    }

    @PostMapping("/add/{productId}/{supplementId}")
    public String addSupplementToProduct(@PathVariable String productId,
                                         @PathVariable String supplementId){
        productService.addSupplementToProduct(productId, supplementId);
        return "redirect:/supplement/" + productId;
    }

    @PostMapping ("/delete/{productId}/{supplementId}")
    public String removeSupplementToProduct(@PathVariable String productId,
                                         @PathVariable String supplementId){
        productService.removeSupplementFromProduct(productId, supplementId);
        return "redirect:/supplement/" + productId;
    }
}
