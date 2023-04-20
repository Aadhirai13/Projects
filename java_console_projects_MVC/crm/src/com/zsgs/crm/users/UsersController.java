package com.zsgs.crm.users;

import java.util.ArrayList;

public class UsersController implements UsersViewControllerCallBack , UsersModelControllerCallBack {
	private UsersControllerViewCallBack usersView;
	private UsersControllerModelCallBack usersModel;

	public UsersController(UsersView usersView) {
		this.usersView = usersView;
		usersModel = new UsersModel(this);
	}

	public void validateUserCredentials(String userName, String mobileNumber){
		usersModel.validateUserCredentials(userName,mobileNumber);
	}

	public void userSignUp(String userName, String mobileNumber) {
		usersModel.userSignUp(userName,mobileNumber);
	}

	public void loginSucess(String string) {
		usersView.loginSuccess(string);
	}
	
	public void loginFailure(String string) {
		usersView.loginFailure(string);
	}

	public void showCallDetails(ArrayList<Integer> callDetails,String userName,String mobileNumber) {
		usersView.showCallDetails(callDetails,userName,mobileNumber);
	}

	public void storeContactDetails(String userName, String mobileNumber, String location, String accountNumber,
			int loanAmount,int monthlyInterestPercent) {
		usersModel.storeContactDetails(userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent);
	}

	public void dealConfirmed(float monthlyInterestAmount) {
		usersView.dealConfirmed(monthlyInterestAmount);
	}

	public void noCallsYet(String string) {
		usersView.noCallsYet(string);
	}

	public void showContactDetails(ArrayList contactDetails) {
		usersView.showContactDetails(contactDetails);
	}

}
