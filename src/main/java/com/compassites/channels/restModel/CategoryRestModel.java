package com.compassites.channels.restModel;

import javax.validation.constraints.NotNull;

public class CategoryRestModel {
	
	@NotNull(message="categoryName should not be null")
	private String categoryName;
	@NotNull(message="categoryCreatedUserId should not be null")
	private String categoryCreatedUserId;
	@NotNull(message="modifiedUserId should not be null")
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
