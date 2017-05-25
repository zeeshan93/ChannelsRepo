package com.compassites.channels.daoModel;

public class VCardModel {
	private String userName;
	private String vCard;
	private String createdDateTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getvCard() {
		return vCard;
	}
	public void setvCard(String vCard) {
		this.vCard = vCard;
	}
	public String getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
}
