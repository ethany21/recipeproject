package com.github.spring.recipeproject.controllers;

import com.github.spring.recipeproject.domain.Category;
import com.github.spring.recipeproject.domain.UnitOfMeasure;
import com.github.spring.recipeproject.repository.CategoryRepository;
import com.github.spring.recipeproject.repository.UnitOfMeasureRepository;
import com.github.spring.recipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Getting Index Page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
