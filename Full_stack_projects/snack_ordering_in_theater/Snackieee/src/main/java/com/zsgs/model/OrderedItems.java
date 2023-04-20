package com.zsgs.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderedItems {

	public OrderedItems(ResultSet set) throws SQLException {
		this.order_id = set.getInt("order_id");
		this.mail_id = set.getString("mail_id");
		this.amount_paid = set.getString("amount_paid");
		this.ordered_date = set.getDate("ordered_date");
	}
	
	private int order_id;
	private String mail_id;
	private String amount_paid;
	private Date ordered_date;
	
	public int getOrder_id() {
		return order_id;
	}
	public String getMail_id() {
		return mail_id;
	}
	public String getAmount_paid() {
		return amount_paid;
	}
	public Date getOrdered_date() {
		return ordered_date;
	}
}
