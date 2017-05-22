package com.compassites.channels.service;

import com.compassites.channels.daoModel.CategoryModel;

public interface CategoryService {

	String createCategory(CategoryModel categoryModel);

	CategoryModel retrieveCategory(int categoryId);

	String updateCategory(CategoryModel categoryModel);

	String deleteCategory(int categoryId);

}
