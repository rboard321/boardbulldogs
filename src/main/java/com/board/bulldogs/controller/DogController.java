package com.board.bulldogs.controller;

import com.board.bulldogs.service.DogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public String listDogs(Model model) {
        model.addAttribute("dogs", dogService.findAll());
        return "dogs";
    }

    @GetMapping("/dogs/{id}")
    public String dogDetails(@PathVariable Long id, Model model) {
        var dog = dogService.findById(id).orElse(null);
        if (dog == null) {
            return "redirect:/dogs";
        }
        model.addAttribute("dog", dog);
        return "dog-details";
    }
}
