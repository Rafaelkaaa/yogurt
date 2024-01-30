package com.yogurt.controller;

import com.yogurt.dto.CardVO;
import com.yogurt.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/card")
public class CardController {
    CardService cardService;
    @GetMapping("/{cardId}")
    public String findAll(@PathVariable String cardId,
                          Model model) {
        model.addAttribute("card", cardService.findById(cardId));
        model.addAttribute("cardVO", new CardVO());
        return "/customers/card/view";
    }

    @PostMapping("/add")
    public String addProductToCard(@ModelAttribute CardVO cardVO) {
        cardService.addProductToCard(cardVO);
        return "redirect:/card/" + cardVO.getCardId();
    }

    @PostMapping("/delete")
    public String deleteProductToCard(@ModelAttribute CardVO cardVO) {
        cardService.removeProductFromCard(cardVO);
        return "redirect:/card/" + cardVO.getCardId();
    }
}
