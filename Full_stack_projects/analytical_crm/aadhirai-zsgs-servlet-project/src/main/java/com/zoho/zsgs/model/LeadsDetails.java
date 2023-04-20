package com.zoho.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeadsDetails {
		public LeadsDetails(ResultSet set) throws SQLException {
			this.leadName = set.getString("username");
			this.mobileNumber = set.getString("mobileNumber");
		}
		
		public String leadName;
		public String mobileNumber;
	
}
