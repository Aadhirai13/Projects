package com.zsgs.crm.users;

import java.util.ArrayList;

public interface UsersModelControllerCallBack {

	void showCallDetails(ArrayList<Integer> callDetails, String userName, String mobileNumber);

	void noCallsYet(String string);

	void showContactDetails(ArrayList contactDetails);

	void loginSucess(String string);

	void dealConfirmed(float monthlyInterestAmount);

	void loginFailure(String string);

}
