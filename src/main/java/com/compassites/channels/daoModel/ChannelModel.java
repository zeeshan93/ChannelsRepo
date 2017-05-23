package com.compassites.channels.daoModel;



public class ChannelModel {
	private int channel_id;
	private String channel_created_user_id;
	private String channel_title;
	private String channel_profile_image_path;
	private String channel_description;
	private String channel_prefer_gender;
	private String created_date;
	private String modified_user_id;
	private String modified_date;
	private int isactive;

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public String getChannel_created_user_id() {
		return channel_created_user_id;
	}

	public void setChannel_created_user_id(String channel_created_user_id) {
		this.channel_created_user_id = channel_created_user_id;
	}

	public String getChannel_title() {
		return channel_title;
	}

	public void setChannel_title(String channel_title) {
		this.channel_title = channel_title;
	}

	public String getChannel_profile_image_path() {
		return channel_profile_image_path;
	}

	public void setChannel_profile_image_path(String channel_profile_image_path) {
		this.channel_profile_image_path = channel_profile_image_path;
	}

	public String getChannel_description() {
		return channel_description;
	}

	public void setChannel_description(String channel_description) {
		this.channel_description = channel_description;
	}

	public String getChannel_prefer_gender() {
		return channel_prefer_gender;
	}

	public void setChannel_prefer_gender(String channel_prefer_gender) {
		this.channel_prefer_gender = channel_prefer_gender;
	}



	public String getModified_user_id() {
		return modified_user_id;
	}

	public void setModified_user_id(String modified_user_id) {
		this.modified_user_id = modified_user_id;
	}

	
	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

}

