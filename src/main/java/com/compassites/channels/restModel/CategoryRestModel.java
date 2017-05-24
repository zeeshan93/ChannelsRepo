package com.compassites.channels.restModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryRestModel {

	@Size(min = 3,message = "Category Name must be greater than 3 characters")
	private String categoryName;

	@NotNull(message = "Category Created UserId should not be null")
	private String categoryCreatedUserId;

	@NotNull(message = "Modified UserId should not be null")
	private String modifiedUserId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCreatedUserId() {
		return categoryCreatedUserId;
	}

	public void setCategoryCreatedUserId(String categoryCreatedUserId) {
		this.categoryCreatedUserId = categoryCreatedUserId;
	}

	public String getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

}
