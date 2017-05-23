package com.compassites.channels.restModel;

public class ChannelRestModel {	
	private String channelCreatedUserId;
	private String channelTitle;
	private String channelProfileImagePath;
	private String channelDescription;
	private String channelPreferGender;
	private String modifiedUserId;
	public String getChannelCreatedUserId() {
		return channelCreatedUserId;
	}
	public void setChannelCreatedUserId(String channelCreatedUserId) {
		this.channelCreatedUserId = channelCreatedUserId;
	}
	public String getChannelTitle() {
		return channelTitle;
	}
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	public String getChannelProfileImagePath() {
		return channelProfileImagePath;
	}
	public void setChannelProfileImagePath(String channelProfileImagePath) {
		this.channelProfileImagePath = channelProfileImagePath;
	}
	public String getChannelDescription() {
		return channelDescription;
	}
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}
	public String getChannelPreferGender() {
		return channelPreferGender;
	}
	public void setChannelPreferGender(String channelPreferGender) {
		this.channelPreferGender = channelPreferGender;
	}
	public String getModifiedUserId() {
		return modifiedUserId;
	}
	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}	
}
