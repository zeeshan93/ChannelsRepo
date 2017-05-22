package com.compassites.channels.daoModel;

public class CategoryModel {
	private int categoryId;
	private String categoryName;
	private String categoryCreatedUserId;
	private String categoryCreatedDate;
	private String modifiedUserId;
	private String modifiedDate;
	private int isActive;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
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
	public String getCategoryCreatedDate() {
		return categoryCreatedDate;
	}
	public void setCategoryCreatedDate(String categoryCreatedDate) {
		this.categoryCreatedDate = categoryCreatedDate;
	}
	public String getModifiedUserId() {
		return modifiedUserId;
	}
	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
}
