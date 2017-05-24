package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.Exception.CategoryException;
import com.compassites.channels.dao.CategoryDAO;
import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public String createCategory(CategoryRestModel categoryModel) {
		if(categoryDAO.createCategory(categoryModel) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public CategoryModel retrieveCategory(String categoryId) throws CategoryException {
		return categoryDAO.retrieveCategory(categoryId);
		
	}

	@Override
	public String updateCategory(CategoryRestModel categoryModel, String categoryId) {
		if(categoryDAO.updateCategory(categoryModel, categoryId) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public String deleteCategory(String categoryId) {
		if(categoryDAO.deleteCategory(categoryId) > 0){
			return "successful";
		} else{
			return "failed";
		}
		
	}

}
