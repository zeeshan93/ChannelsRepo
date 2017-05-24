package com.compassites.channels.restModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChannelRestModel {	
	
	@NotNull(message="Channel Created User Id should not be null")
	private String channelCreatedUserId;
	
	@Size(min=3,message="Channel Title must be greater than 3 characters")
	private String channelTitle;
	
	@NotNull
	private String channelProfileImagePath;

	@Size(min=5,message="Channel Description must be greater than 5 characters")
	private String channelDescription;
	
	@NotNull
	private String channelPreferGender;
	
	@NotNull
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
