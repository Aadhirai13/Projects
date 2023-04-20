package com.zoho.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dashboard {

	public Dashboard(ResultSet set) throws SQLException {
		this.userName = set.getString("userName");
		this.individualProfitPercent = set.getFloat("individualProfitPercent");
	}

	public String userName;
	public float individualProfitPercent;
}
