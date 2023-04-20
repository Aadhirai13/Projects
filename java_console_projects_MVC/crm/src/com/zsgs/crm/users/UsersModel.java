package com.zsgs.crm.users;

import java.util.ArrayList;

import com.zsgs.crm.repository.CrmRepository;

public class UsersModel implements UsersControllerModelCallBack{
	private UsersModelControllerCallBack usersController;

	public UsersModel(UsersController usersController) {
		this.usersController = usersController;
	}

	public void validateUserCredentials(String userName, String mobileNumber){
		boolean isExistingUser = CrmRepository.getInstance().validateUserCredentials(userName,mobileNumber);
		
		if(isExistingUser) {
			boolean isLead = CrmRepository.getInstance().isLead(mobileNumber);
			if(isLead) {
				boolean isCallRecieved = CrmRepository.getInstance().isCallRecieved(mobileNumber);
				if(isCallRecieved) {
					ArrayList<Integer> callDetails = CrmRepository.getInstance().getCallDetails(mobileNumber);
					usersController.showCallDetails(callDetails,userName,mobileNumber);
				}
				else {
					usersController.noCallsYet("You didn't recieved any calls yet...");
				}
			}
			else {
				ArrayList contactDetails = CrmRepository.getInstance().getContactDetails(mobileNumber);
				usersController.showContactDetails(contactDetails);
			}
		}
		else {
			usersController.loginFailure("Invalid credentials");
		}
	}

	public void userSignUp(String userName, String mobileNumber) {
		boolean isExistingUser = CrmRepository.getInstance().userSignUp(userName,mobileNumber);
		if(isExistingUser)
			usersController.loginSucess("You are an existing user");
		else
			usersController.loginSucess("Signed Up successfully");
	}

	public void storeContactDetails(String userName, String mobileNumber, String location, String accountNumber,
			int loanAmount,int monthlyInterestPercent) {
		float monthlyInterestAmount = ((float)monthlyInterestPercent/100) * loanAmount;
		CrmRepository.getInstance().storeContactDetails(userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent,monthlyInterestAmount);
		usersController.dealConfirmed(monthlyInterestAmount);
	}

}
