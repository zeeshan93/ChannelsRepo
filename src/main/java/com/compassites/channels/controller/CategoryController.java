package com.compassites.channels.controller;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compassites.channels.Exception.CategoryException;
import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;
import com.compassites.channels.service.CategoryService;
import com.compassites.channels.utils.JsonObject;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JSONObject createCategory(@RequestBody @Valid CategoryRestModel categoryModel, BindingResult bindingResult) {
		JSONObject jsonObj = new JSONObject();

		if (bindingResult.hasErrors()) {
			return JsonObject.getJsonObjectFromBindingResult(bindingResult);
		}
		JsonObject.getJsonObjectFromBindingResult(bindingResult);
		jsonObj.put("status", 200);
		jsonObj.put("message", "Adding category " + categoryService.createCategory(categoryModel));
		return jsonObj;
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public CategoryModel retrieveCategory(@RequestParam(value = "categoryId") String categoryId)
			throws CategoryException {
		try {
			return categoryService.retrieveCategory(categoryId);
		} catch (CategoryException e) {
			throw new CategoryException(e.getMessage());
		}
	}

	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public JSONObject updateCategory(@RequestBody @Valid CategoryRestModel categoryModel, BindingResult bindingResult,
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
