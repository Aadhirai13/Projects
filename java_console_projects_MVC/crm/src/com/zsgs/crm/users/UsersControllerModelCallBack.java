package com.zsgs.crm.users;

public interface UsersControllerModelCallBack {

	void validateUserCredentials(String userName, String mobileNumber);

	void userSignUp(String userName, String mobileNumber);

	void storeContactDetails(String userName, String mobileNumber, String location, String accountNumber,
			int loanAmount, int monthlyInterestPercent);

}
