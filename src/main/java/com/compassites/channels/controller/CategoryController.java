package com.compassites.channels.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;
import com.compassites.channels.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JSONObject createCategory(@RequestBody CategoryRestModel categoryModel) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Adding category " + categoryService.createCategory(categoryModel));
		return jsonObj;
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public CategoryModel retrieveCategory(@RequestParam(value = "categoryId") String categoryId) {
		return categoryService.retrieveCategory(categoryId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public JSONObject updateCategory(@RequestBody CategoryRestModel categoryModel,
			@RequestParam("categoryId") String categoryId) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Updating category for " + categoryModel.getCategoryName() + " is "
				+ categoryService.updateCategory(categoryModel, categoryId));
		return jsonObj;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public JSONObject deleteCategory(@RequestParam(value = "categoryId") String categoryId) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Deleted Category with category id = " + categoryId + " is "
				+ categoryService.deleteCategory(categoryId));
		return jsonObj;
	}
}
