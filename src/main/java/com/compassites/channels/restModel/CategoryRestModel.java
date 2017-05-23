package com.compassites.channels.restModel;

public class CategoryRestModel {
	private String categoryName;
	private String categoryCreatedUserId;
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
