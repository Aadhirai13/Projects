package com.zsgs.crm.users;

import java.util.ArrayList;

import com.zsgs.crm.repository.CrmRepository;

public class UsersViewModel{
	private UsersView usersView;

	public UsersViewModel(UsersView usersView) {
		this.usersView = usersView;
	}

	public void validateUserCredentials(String userName, String mobileNumber){
		boolean isExistingUser = CrmRepository.getInstance().validateUserCredentials(userName,mobileNumber);
		
		if(isExistingUser) {
			boolean isLead = CrmRepository.getInstance().isLead(mobileNumber);
			if(isLead) {
				boolean isCallRecieved = CrmRepository.getInstance().isCallRecieved(mobileNumber);
				if(isCallRecieved) {
					ArrayList<Integer> callDetails = CrmRepository.getInstance().getCallDetails(mobileNumber);
					usersView.showCallDetails(callDetails,userName,mobileNumber);
				}
				else {
					usersView.noCallsYet("You didn't recieved any calls yet...");
				}
			}
			else {
				ArrayList contactDetails = CrmRepository.getInstance().getContactDetails(mobileNumber);
				usersView.showContactDetails(contactDetails);
			}
		}
		else {
			usersView.loginFailure("Invalid credentials");
		}
	}

	public void userSignUp(String userName, String mobileNumber) {
		boolean isExistingUser = CrmRepository.getInstance().userSignUp(userName,mobileNumber);
		if(isExistingUser)
			usersView.loginSuccess("You are an existing user");
		else
			usersView.loginSuccess("Signed Up successfully");
	}

	public void storeContactDetails(String userName, String mobileNumber, String location, String accountNumber,
			int loanAmount,int monthlyInterestPercent) {
		float monthlyInterestAmount = ((float)monthlyInterestPercent/100) * loanAmount;
		CrmRepository.getInstance().storeContactDetails(userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent,monthlyInterestAmount);
		usersView.dealConfirmed(monthlyInterestAmount);
	}

}
