package com.compassites.channels.utils;

import java.util.LinkedHashMap;
import java.util.Set;

public class Insert {
	
//	INSERT INTO category(category_name,category_created_user_id,created_date,modified_user_id,modified_date,isactive) VALUES(?,?,?,?,?,?)
	
	private StringBuilder query = new StringBuilder();
	
	private String table = null;
	private LinkedHashMap<String, Object> paramsMap = null;
	
	private static Insert instance;
	
	private Insert(String table){
		this.table = table;
	}
	
	public static Insert toTable(String tableName){
		instance = new Insert(tableName);
		return instance;
	}
	
	public Insert addFields(String key, Object value){
		paramsMap.put(key, value);
		return this;
	}
	
	/*public Insert setParams(LinkedHashMap<String, Object> params){
		this.paramsMap = params;
		return this;
	}*/
	
	public String build(){
		query.append("insert into ");
		query.append(table);
		query.append("(");
		query.append(getKeysFromParamsMap());
		query.append(")");
		query.append("VALUES");
		query.append("(");
		query.append(getValuesFromParamsMap());
		query.append(")");
		return query.toString();
	}


	private String getKeysFromParamsMap() {
		StringBuilder keys = new StringBuilder();
		Set<String> paramsKey = paramsMap.keySet();
		for(String key : paramsKey){
			if(!keys.toString().isEmpty()){
				keys.append(",");
			} 
			keys.append(key);
		}
		return keys.toString();
	}

	
	private String getValuesFromParamsMap() {
		StringBuilder values = new StringBuilder();
		Set<Object> paramsValues = (Set<Object>) paramsMap.values();
		for(Object value : paramsValues){
			if(!values.toString().isEmpty()){
				values.append(",");
			} 
			values.append(value);
		}
		return values.toString();
	}
}
