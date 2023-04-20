package com.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderedItemsDetails {
	public OrderedItemsDetails(ResultSet set) throws SQLException {
		this.order_id = set.getInt("order_id");
		this.mail_id = set.getString("mail_id");	
		this.category_id = set.getInt("category_id");
		this.snack_id = set.getInt("snack_id");	
		this.snack_name = set.getString("snack_name");
		this.snack_count = set.getInt("snack_count");
		this.snack_amount = set.getInt("snack_amount");
	}
	
	private int order_id;
	private String mail_id;
	private int category_id;
	private int snack_id;
	private String snack_name;
	private int snack_count;
	private float snack_amount;
	
	public int getOrder_id() {
		return order_id;
	}
	public String getMail_id() {
		return mail_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public int getSnack_id() {
		return snack_id;
	}
	public String getSnack_name() {
		return snack_name;
	}
	public int getSnack_count() {
		return snack_count;
	}
	public float getSnack_amount() {
		return snack_amount;
	}

	
	
}
