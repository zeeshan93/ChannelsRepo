package com.compassites.channels.restModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgeGroupRestModel {
	
	@NotNull(message = "Minimum Age Group should not be null")
	private int ageGroupMin;
	
	@NotNull(message = "Maximum Age Group should not be null")
	private int ageGroupMax;
	
	@Size(min = 5,message = "Age Group Descripution must be greater than 5 characters")
	private String ageGroupDescription;
	
	// private String createdDate;
	
	@NotNull(message = "Modified User Id should not be null")
	private String modifiedUserId;

	// private String modifiedDate;
	// private int isActive;
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

	/*
	 * public String getCreatedDate() { return createdDate; } public void
	 * setCreatedDate(String createdDate) { this.createdDate = createdDate; }
	 */
	public String getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	/*
	 * public String getModifiedDate() { return modifiedDate; } public void
	 * setModifiedDate(String modifiedDate) { this.modifiedDate = modifiedDate;
	 * }
	 */
	/*
	 * public int getIsActive() { return isActive; } public void setIsActive(int
	 * isActive) { this.isActive = isActive; }
	 */

}
