package com.github.spring.recipeproject.repository;

import com.github.spring.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
