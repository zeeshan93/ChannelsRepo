package com.compassites.channels.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.compassites.channels.Exception.CategoryException;
import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.CategoryRestModel;
import com.compassites.channels.utils.ChannelConstants;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createCategory(CategoryRestModel categoryModel) {

		UUID uuid = UUID.randomUUID();
		String categoryId = uuid.toString();

		String createdDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		createdDate = sdf.format(new Date());

		String sql = ChannelConstants.createCategoryQuery;
		/*
		 * 
		 * ** Using query builder of insert **
		 * 
		 * 
		 * String tableName = Tables.CATEGORY; LinkedHashMap<String, String>
		 * paramsMap = new LinkedHashMap<>();
		 * paramsMap.put(Columns.categoryName, categoryModel.getCategoryName());
		 * paramsMap.put(Columns.categoryCreatedUserId,
		 * categoryModel.getCategoryCreatedUserId());
		 * paramsMap.put(Columns.createdDate,
		 * categoryModel.getCategoryCreatedDate());
		 * paramsMap.put(Columns.modifiedUserId,
		 * categoryModel.getModifiedUserId());
		 * paramsMap.put(Columns.modifiedDate, categoryModel.getModifiedDate());
		 * paramsMap.put(Columns.isActive,
		 * Integer.toString(categoryModel.getIsActive()));
		 * 
		 * 
		 * String sql = Insert.toTable(tableName)
		 * .addFields(Columns.categoryName, categoryModel.getCategoryName())
		 * .addFields(Columns.categoryCreatedUserId,
		 * categoryModel.getCategoryCreatedUserId())
		 * .addFields(Columns.createdDate,
		 * categoryModel.getCategoryCreatedDate())
		 * .addFields(Columns.modifiedUserId, categoryModel.getModifiedUserId())
		 * .addFields(Columns.modifiedDate, categoryModel.getModifiedDate())
		 * .addFields(Columns.isActive,
		 * Integer.toString(categoryModel.getIsActive())) .build();
		 * 
		 */

		return jdbcTemplate.update(sql, categoryId, categoryModel.getCategoryName(),
				categoryModel.getCategoryCreatedUserId(), createdDate, categoryModel.getModifiedUserId());
	}

	@Override
	public CategoryModel retrieveCategory(String categoryId) throws CategoryException {

		Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM category where category_id = ?",
				Integer.class, categoryId);
		if (count > 0) {
			String selectQuery = ChannelConstants.selectCategoryQuery;
			
			CategoryModel categoryModel = (CategoryModel) jdbcTemplate.queryForObject(selectQuery,
					new Object[] { categoryId }, new BeanPropertyRowMapper(CategoryModel.class));
			return categoryModel;

		} else {
			throw new CategoryException("Invalid Category Id. Please Enter a valid Category Id.");
		}
	}

	@Override
	public int updateCategory(CategoryRestModel categoryModel, String categoryId) {
		String sql = ChannelConstants.updateCategoryQuery;
		return jdbcTemplate.update(sql, categoryModel.getCategoryName(), categoryModel.getCategoryCreatedUserId(),
				categoryModel.getModifiedUserId(), categoryId);
	}

	@Override
	public int deleteCategory(String categoryId) {
		String sql = ChannelConstants.deleteCategoryQuery;
		return jdbcTemplate.update(sql, categoryId);
	}
}
