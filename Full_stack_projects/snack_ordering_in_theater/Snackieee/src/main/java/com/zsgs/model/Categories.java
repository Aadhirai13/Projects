package com.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Categories {

	public Categories(ResultSet set) throws SQLException {
		this.category = set.getString("category");
		this.category_id = set.getInt("category_id");
		this.category_image = set.getString("category_image");
		this.category_desc = set.getString("category_desc");
	}
	
	private String category;
	private int category_id;
	private String category_image;
	private String category_desc;
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}
	
	public int getCategoryId() {
		return this.category_id;
	}
	
	public void setCategoryImage(String category_image) {
		this.category_image = category_image;
	}
	
	public String getCategoryImage() {
		return this.category_image;
	}
	
	public void setCategoryDesc(String category_desc) {
		this.category_desc = category_desc;
	}
	
	public String getCategoryDesc() {
		return this.category_desc;
	}
	
}
