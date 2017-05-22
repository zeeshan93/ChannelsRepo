package com.compassites.channels.daoModel;

public class AgeGroupModel {
	private int ageGroupId;
	private int ageGroupMin;
	private int ageGroupMax;
	private String ageGroupDescription;
	private String createdDate;
	private String modifiedUserId;
	private String modifiedDate;
	private int isActive;
	
	public int getAgeGroupId() {
		return ageGroupId;
	}
	public void setAgeGroupId(int ageGroupId) {
		this.ageGroupId = ageGroupId;
	}
	public int getAgeGroupMin() {
		return ageGroupMin;
	}
	public void setAgeGroupMin(int ageGroupMin) {
		this.ageGroupMin = ageGroupMin;
	}
	public int getAgeGroupMax() {
		return ageGroupMax;
	}
	public void setAgeGroupMax(int ageGroupMax) {
		this.ageGroupMax = ageGroupMax;
	}
	public String getAgeGroupDescription() {
		return ageGroupDescription;
	}
	public void setAgeGroupDescription(String ageGroupDescription) {
		this.ageGroupDescription = ageGroupDescription;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
