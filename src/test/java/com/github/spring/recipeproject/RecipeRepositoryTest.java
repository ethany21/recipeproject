package com.github.spring.recipeproject;

import com.github.spring.recipeproject.domain.Category;
import com.github.spring.recipeproject.domain.Difficulty;
import com.github.spring.recipeproject.domain.Recipe;
import com.github.spring.recipeproject.repository.CategoryRepository;
import com.github.spring.recipeproject.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void recipeRepositoryTest() {
        Recipe recipe1 = new Recipe();
        recipe1.setDifficulty(Difficulty.HARD);
        recipe1.setDescription("Mexican");

        recipeRepository.save(recipe1);

        Iterable<Recipe> iterable = recipeRepository.findAll();

        for (Recipe recipe : iterable) {
            assertThat(recipe.getDescription().equals("Mexican"));
            assertThat(recipe.getDifficulty().equals(Difficulty.HARD));
        }
    }


}
