package com.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SnackDetails {

	public SnackDetails(ResultSet set) throws SQLException {
		this.category_id = set.getInt("category_id");
		this.snack_id = set.getInt("snack_id");
		this.snack_name = set.getString("snack_name");
		this.price = set.getInt("price");
		this.stock = set.getInt("stock");
		this.quantity = set.getString("quantity");
		this.snack_image = set.getString("snack_image");
	}
	
	private int category_id;
	private int snack_id;
	private String snack_name;
	private float price;
	private int stock;
	private String quantity;
	private String snack_image;
	
	public String getSnackName() {
		return this.snack_name;
	}

	
	public String getSnackImage() {
		return this.snack_image;
	}

	public String getQuantity() {
		return this.quantity;
	}
	
	public float getPrice() {
		return this.price;
	}

	public int getSnackId() {
		return this.snack_id;
	}
	
	public int getCategoryId() {
		return this.category_id;
	}

	public int getStock() {
		return this.stock;
	}

}
