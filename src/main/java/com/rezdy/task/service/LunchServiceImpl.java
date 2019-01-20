package com.rezdy.task.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezdy.task.model.Ingredients;
import com.rezdy.task.model.Recipe;
import com.rezdy.task.model.Recipes;

@Service
public class LunchServiceImpl implements LunchService {

	@Value("classpath:recipes.json")
	Resource recipiesResource;

	@Value("classpath:ingredients.json")
	Resource ingredientsResource;

	@Override
	public Recipes getLunch() {
		
		List<Recipe> lunchRecipeList = new ArrayList<>();
		List<Recipe> bestBeforeRecipes = new ArrayList<>();

		Recipes recipes = this.readJson(recipiesResource, Recipes.class);
		Ingredients ingredients = this.readJson(ingredientsResource, Ingredients.class);
		
		//  Filtering the ingredients whose use by is passed current date. and collecting titles
		
		List<String> ingredientsPassedUseBy = ingredients.getIngredients().stream()
				.filter(ingredient -> ingredient.getUseBy().before(new Date()))
				.map(ingredient -> ingredient.getTitle())
				.collect(Collectors.toList());
		
		//  Filtering the ingredients whose bast before is passed current date. and collecting titles
		List<String> ingredientsPassedBestBefore = ingredients.getIngredients().stream()
				.filter(ingredient -> ingredient.getBestBefore().before(new Date()))
				.map(ingredient -> ingredient.getTitle())
				.collect(Collectors.toList());
		
		if(!CollectionUtils.isEmpty(recipes.getRecipes())){
			recipes.getRecipes().forEach(recipe -> {
				// if ingredients of current recipe are not present in ingredientsPassedUseBy
				 if(!CollectionUtils.containsAny(recipe.getIngredients(), ingredientsPassedUseBy)){
					// if ingredients of current recipe are present in ingredientsPassedBestBefore add to bestBeforeRecipes list
					 if(CollectionUtils.containsAny(recipe.getIngredients(), ingredientsPassedBestBefore)){						 
						 bestBeforeRecipes.add(recipe);
					 }else{
					// if ingredients of current recipe are not present in ingredientsPassedBestBefore add to bestBeforeRecipes list
						 lunchRecipeList.add(recipe);
					 }
				 }
			});
			// add bestBefore past recipes at the end of the lunch recipe List
			 lunchRecipeList.addAll(bestBeforeRecipes);
		}
		
		return new Recipes(lunchRecipeList);

	}

	private <T> T readJson(Resource resource, Class<T> classType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			T t = mapper.readValue(resource.getFile(), classType);
			return t;

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
