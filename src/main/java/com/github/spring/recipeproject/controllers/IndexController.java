package com.github.spring.recipeproject.controllers;

import com.github.spring.recipeproject.domain.Category;
import com.github.spring.recipeproject.domain.UnitOfMeasure;
import com.github.spring.recipeproject.repository.CategoryRepository;
import com.github.spring.recipeproject.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        System.out.println("catetory is " + categoryOptional.get().getId());
        System.out.println("uom is " + unitOfMeasureOptional.get().getId());

        return "index";
    }

}
