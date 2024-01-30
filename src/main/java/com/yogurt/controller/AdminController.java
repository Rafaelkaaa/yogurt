package com.yogurt.controller;

import com.yogurt.dto.ProductTypeDto;
import com.yogurt.dto.SupplementDto;
import com.yogurt.entity.supplements.SupplementType;
import com.yogurt.service.ProductTypeService;
import com.yogurt.service.SupplementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {
    ProductTypeService productTypeService;
    SupplementService supplementService;

    @GetMapping("/product_type/new")
    public String newProductType(Model model) {
        model.addAttribute("productType", new ProductTypeDto());
        return "/admins/product_type/create";
    }

    @PostMapping("/product_type/new")
    public String createProductType(@ModelAttribute ProductTypeDto productType) {
        productTypeService.save(productType);
        return "redirect:/admin";
    }

    @GetMapping("/supplement/new")
    public String newSupplement(Model model) {
        model.addAttribute("supplement", new SupplementDto());
        model.addAttribute("supplementTypes", Arrays.asList(SupplementType.values()));
        return "/admins/supplement/create";
    }

    @PostMapping("/supplement/new")
    public String createSupplement(@ModelAttribute SupplementDto supplement) {
        supplementService.save(supplement);
        return "redirect:/admin";
    }
}
