package com.rezdy.task.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rezdy.task.model.Recipes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LunchServiceTest {

	@Autowired
	LunchService lunchService;

	@Test
	public void testGetLunch() {

		Recipes recipes = lunchService.getLunch();

		assertThat(recipes.getRecipes().size(), is(3));
		
		List<String> recipeTitles = recipes.getRecipes().stream().map(recipe -> recipe.getTitle())
				.collect(Collectors.toList());

		assertThat(recipeTitles, contains("Ham and Cheese Toastie", "Omelette", "Hotdog"));

	}
}
