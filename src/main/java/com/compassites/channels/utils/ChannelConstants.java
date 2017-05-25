package com.compassites.channels.utils;

public final class ChannelConstants {
	public static final String categoryTable = "category";

	public static final String categoryId = "category_id";
	public static final String categoryName = "category_name";
	public static final String categoryCreatedUserId = "category_created_user_id";

	public static final String createdDate = "created_date";
	public static final String modifiedUserId = "modified_user_id";
	public static final String modifiedDate = "modified_date";
	public static final String isActive = "isactive";
	
	interface Table {
		String CATEGORY = "category";
		
	}
	
	
	interface Column {

		String categoryId = "category_id";
		String categoryName = "category_name";
		String categoryCreatedUserId = "category_created_user_id";
		
		String createdDate = "created_date";
		String modifiedUserId = "modified_user_id";
		String modifiedDate = "modified_date";
		String isActive = "isactive";

	}

	public static final String createCategoryQuery = "INSERT INTO category(category_id, category_name,category_created_user_id,created_date,modified_user_id) VALUES(?,?,?,?,?)";
	public static final String selectCategoryQuery = "select * from category where category_id = ?";
	public static final String updateCategoryQuery =  "UPDATE category SET category_name = ? , category_created_user_id = ? , modified_user_id = ? where category_id = ?";
	public static final String deleteCategoryQuery = "DELETE FROM category where category_id = ?";
	
	public static final String createAgeGroupQuery = "INSERT INTO age_group(age_group_id,age_group_min,age_group_max,age_group_description,created_date,modified_user_id) VALUES(?,?,?,?,?,?)";
	public static final String selectAgeGroupQuery = "select * from age_group where age_group_id = ?";
	public static final String updateAgeGroupQuery = "UPDATE age_group SET age_group_min = ? , age_group_max = ? , age_group_description = ? , modified_user_id = ? where age_group_id = ?";
	public static final String deleteAgeGroupQuery = "DELETE FROM age_group where age_group_id = ?";
	public static final String selectAgeGroupIdFromAgeGroupQuery = "SELECT age_group_id FROM channels.age_group WHERE ? between age_group_min and age_group_max";
	
	public static final String selectVcardByUserId = "SELECT vcard from vcard where username = ?";
}
