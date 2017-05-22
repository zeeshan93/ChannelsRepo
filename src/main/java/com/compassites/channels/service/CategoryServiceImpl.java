package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.dao.CategoryDAO;
import com.compassites.channels.daoModel.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public String createCategory(CategoryModel categoryModel) {
		if(categoryDAO.createCategory(categoryModel) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public CategoryModel retrieveCategory(int categoryId) {
		return categoryDAO.retrieveCategory(categoryId);
		
	}

	@Override
	public String updateCategory(CategoryModel categoryModel) {
		if(categoryDAO.updateCategory(categoryModel) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public String deleteCategory(int categoryId) {
		if(categoryDAO.deleteCategory(categoryId) > 0){
			return "successful";
		} else{
			return "failed";
		}
		
	}

}
