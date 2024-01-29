package com.yogurt.controller;

import com.yogurt.dto.CardVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/admin/product")
public class ProductController {

    @GetMapping
    public String findAll()  {
        return "/test";
    }
}

