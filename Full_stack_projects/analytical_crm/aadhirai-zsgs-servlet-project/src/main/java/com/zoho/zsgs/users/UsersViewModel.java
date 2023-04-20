package com.zoho.zsgs.users;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zoho.zsgs.model.ContactDetails;
import com.zoho.zsgs.repository.CrmRepository;



public class UsersViewModel{
	
	public static UsersViewModel usersViewModel;

	private UsersViewModel() {
	}

	public static UsersViewModel getInstance() {
			if (usersViewModel == null) {
				usersViewModel = new UsersViewModel();
			}
		return usersViewModel;
	}
	
	public boolean validateUserCredentials(String userName, String mobileNumber){
		boolean isExistingUser = CrmRepository.getInstance().validateUserCredentials(userName,mobileNumber);
		return isExistingUser;
	}

	public boolean userSignUp(String userName, String mobileNumber) {
		boolean isExistingUser = CrmRepository.getInstance().userSignUp(userName,mobileNumber);
		return isExistingUser;
	}

	public float storeContactDetails(String location, String accountNumber,int loanAmount) {
		int monthlyInterestPercent = 2;
		float monthlyInterestAmount = ((float)monthlyInterestPercent/100) * loanAmount;
		String mobileNumber = CrmRepository.getInstance().getNumber();
		String userName = CrmRepository.getInstance().getUsername();
		CrmRepository.getInstance().storeContactDetails(userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent,monthlyInterestAmount);
		return monthlyInterestAmount;
	}

	public boolean isLead(String mobileNumber) {
		boolean isLead = CrmRepository.getInstance().isLead(mobileNumber);
		return isLead;
	}

	public boolean isCallRecieved() {
		String mobileNumber = CrmRepository.getInstance().getNumber();
		boolean isCallRecieved = CrmRepository.getInstance().isCallRecieved(mobileNumber);
		return isCallRecieved;
	}

	public ArrayList<Integer> getCallDetails() {
		String mobileNumber = CrmRepository.getInstance().getNumber();
		ArrayList<Integer> callDetails = CrmRepository.getInstance().getCallDetails(mobileNumber);
		return callDetails;
	}

	public List<ContactDetails> getContactDetails() {
		String mobileNumber = CrmRepository.getInstance().getNumber();
		List<ContactDetails> contactDetails = CrmRepository.getInstance().getContactDetails(mobileNumber);
		return contactDetails;
	}

	public boolean checkMobileNumberValid(String mobileNumber) {
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(mobileNumber);
		return matcher.matches();
	}

}
