package com.compassites.channels.service;

import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;

public interface CategoryService {

	String createCategory(CategoryRestModel categoryModel);

	CategoryModel retrieveCategory(String categoryId);

	String updateCategory(CategoryRestModel categoryModel, String categoryId);

	String deleteCategory(String categoryId);

}
