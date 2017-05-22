package com.compassites.channels.dao;

import com.compassites.channels.daoModel.CategoryModel;

public interface CategoryDAO {

	int createCategory(CategoryModel categoryModel);

	CategoryModel retrieveCategory(int categoryId);

	int updateCategory(CategoryModel categoryModel);

	int deleteCategory(int categoryId);

}
