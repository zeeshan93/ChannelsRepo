package com.compassites.channels.dao;

import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;

public interface CategoryDAO {

	int createCategory(CategoryRestModel categoryModel);

	CategoryModel retrieveCategory(String categoryId);

	int updateCategory(CategoryRestModel categoryModel, String categoryId);

	int deleteCategory(String categoryId);

}
