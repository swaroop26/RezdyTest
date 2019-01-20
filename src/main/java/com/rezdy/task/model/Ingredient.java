package com.rezdy.task.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5823824617448116117L;

    @JsonProperty("title")
	private String title;
    
    @JsonProperty("best-before")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date bestBefore;
    @JsonProperty("use-by")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date useBy;

	public Ingredient() {
		super();
	}

	public Ingredient(String title) {
		super();
		this.title = title;
	}

	public Ingredient(String title, Date bestBefore, Date useBy) {
		super();
		this.title = title;
		this.bestBefore = bestBefore;
		this.useBy = useBy;
	}

	public Date getUseBy() {
		return useBy;
	}

	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}

	public Date getBestBefore() {
		return bestBefore;
	}

	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Ingredients [title=" + title + ", bestBefore=" + bestBefore + ", useBy=" + useBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestBefore == null) ? 0 : bestBefore.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((useBy == null) ? 0 : useBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (bestBefore == null) {
			if (other.bestBefore != null)
				return false;
		} else if (!bestBefore.equals(other.bestBefore))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (useBy == null) {
			if (other.useBy != null)
				return false;
		} else if (!useBy.equals(other.useBy))
			return false;
		return true;
	}

}
