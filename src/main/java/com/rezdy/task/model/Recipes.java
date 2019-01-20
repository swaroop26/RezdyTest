package com.rezdy.task.model;

import java.io.Serializable;
import java.util.List;

public class Recipes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 518198852861638674L;
	
	private List<Recipe> recipes;	

	public Recipes() {
		super();
	}

	public Recipes(List<Recipe> recipes) {
		super();
		this.recipes = recipes;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
