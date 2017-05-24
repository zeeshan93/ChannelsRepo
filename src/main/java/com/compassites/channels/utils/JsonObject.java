package com.compassites.channels.utils;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class JsonObject {
	public static JSONObject getJsonObjectFromBindingResult(BindingResult bindingResult)
	{
		JSONObject jsonObj = new JSONObject();
		
		List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

		JSONObject fieldErrors = new JSONObject();

		for (FieldError fieldError : fieldErrorList) {
			fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		jsonObj.put("status", 400);
		jsonObj.put("message", "Invalid Request");
		jsonObj.put("fieldErrors", fieldErrors);

		return jsonObj;
	}
}
