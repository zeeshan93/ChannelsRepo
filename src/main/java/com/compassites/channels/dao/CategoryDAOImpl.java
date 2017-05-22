package com.compassites.channels.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.utils.ChannelConstants;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createCategory(CategoryModel categoryModel) {
		String sql = ChannelConstants.createCategoryQuery;
		/*   
		 * 
		 *				 ** Using query builder of insert **
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

		return jdbcTemplate.update(sql, categoryModel.getCategoryName(), categoryModel.getCategoryCreatedUserId(),
				categoryModel.getCategoryCreatedDate(), categoryModel.getModifiedUserId(),
				categoryModel.getModifiedDate(), categoryModel.getIsActive());
	}

	@Override
	public CategoryModel retrieveCategory(int categoryId) {
		String selectQuery = ChannelConstants.selectCategoryQuery;

		CategoryModel categoryModel = (CategoryModel) jdbcTemplate.queryForObject(selectQuery,
				new Object[] { categoryId }, new BeanPropertyRowMapper(CategoryModel.class));

		return categoryModel;

	}

	@Override
	public int updateCategory(CategoryModel categoryModel) {
		String sql = ChannelConstants.updateCategoryQuery;
		return jdbcTemplate.update(sql, categoryModel.getCategoryName(), categoryModel.getCategoryCreatedUserId(),
				categoryModel.getCategoryCreatedDate(), categoryModel.getModifiedUserId(),
				categoryModel.getModifiedDate(), categoryModel.getIsActive(), categoryModel.getCategoryId());
	}

	@Override
	public int deleteCategory(int categoryId) {
		String sql = ChannelConstants.deleteCategoryQuery;
		return jdbcTemplate.update(sql, categoryId);
	}
}
