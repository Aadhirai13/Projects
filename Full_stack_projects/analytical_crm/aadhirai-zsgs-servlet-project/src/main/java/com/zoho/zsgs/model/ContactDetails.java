package com.zoho.zsgs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDetails {
	public ContactDetails(ResultSet set) throws SQLException {
		this.loanAmount = set.getInt("loanAmount");
		this.accountNumber = set.getString("accountNumber");
		this.location = set.getString("location");
		this.mobileNumber = set.getString("mobileNumber");
		this.monthlyInterestAmount = set.getFloat("monthlyInterestAmount");
		this.monthlyInterestPercent = set.getInt("monthlyInterestPercent");
		this.userName = set.getString("userName");
		this.individualProfitPercent = set.getFloat("individualProfitPercent");
	
	}

	public String userName;
	public String mobileNumber;
	public String location;
	public String accountNumber;
	public int loanAmount;
	public int monthlyInterestPercent;
	public float monthlyInterestAmount;
	public float individualProfitPercent;
	
//	
//	public void setLoanAmount(int loan) {
//		this.loanAmount = loan;
//	}
//	
//	public int getLoanAmount() {
//		return this.loanAmount;
//	}

}


