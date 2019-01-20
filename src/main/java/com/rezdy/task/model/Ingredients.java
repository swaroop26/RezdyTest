package com.rezdy.task.model;

import java.io.Serializable;
import java.util.List;

public class Ingredients implements Serializable {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6538478031468067204L;
	
	private List<Ingredient> ingredients;

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	 
}
