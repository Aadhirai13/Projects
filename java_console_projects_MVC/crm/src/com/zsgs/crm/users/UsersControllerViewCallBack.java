package com.zsgs.crm.users;

import java.util.ArrayList;

public interface UsersControllerViewCallBack {

	void loginSuccess(String string);

	void showCallDetails(ArrayList<Integer> callDetails, String userName, String mobileNumber);

	void dealConfirmed(float monthlyInterestAmount);

	void noCallsYet(String string);

	void showContactDetails(ArrayList contactDetails);

	void loginFailure(String string);

}
