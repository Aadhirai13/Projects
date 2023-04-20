package com.zoho.zsgs.accounts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zoho.zsgs.model.ContactDetails;
import com.zoho.zsgs.model.Dashboard;
import com.zoho.zsgs.model.LeadsDetails;
import com.zoho.zsgs.repository.CrmRepository;

public class AccountsViewModel {
	
	public static AccountsViewModel accountsViewModel;

	private AccountsViewModel() {
	}

	public static AccountsViewModel getInstance() {
			if (accountsViewModel == null) {
				accountsViewModel = new AccountsViewModel();
			}
		return accountsViewModel;
	}

	public boolean validateAccountsCredentials(String userName, String password) {
//		if(checkUserNameValid(userName)) {
		boolean isValid = CrmRepository.getInstance().validateAccountsCredentials(userName,password);
		if(isValid) {
			CrmRepository.getInstance().updateContacts();
			
			return true;
		}
		else
			return false;
		
	}

	public boolean checkUserNameValid(String userName) {
		Pattern pattern = Pattern.compile("[^aeiouAEIOU][a-zA-z0-9_]*[^aeiouAEIOU]");
		// [a-zA-Z0-9_]+[@][a-z]+[.][a-z]{2,}
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}

	public List<LeadsDetails> getLeads() {
		List<LeadsDetails> leads = CrmRepository.getInstance().getLeads();
		return leads;
	}

	public void callLead(String mobileNumber) {
		CrmRepository.getInstance().callLead(mobileNumber);
	}

	public List<ContactDetails> getContacts() {
		List<ContactDetails> contactDetails = CrmRepository.getInstance().getContacts();
		return contactDetails;
	}

	public boolean checkMobileNumberValid(String password) {
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
//	public void getDashBoardDetails() throws IOException {
//		List<Dashboard> dashboardDetails = CrmRepository.getInstance().getDashboardDetails();
//		
////		Gson gson = new Gson();
////		String jsonString = gson.toJson(dashboardDetails);
////		JsonParser parser = new JsonParser();
////		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
//		
//		// clearing data of json file
////		PrintWriter writer = new PrintWriter("C:\\Users\\dhili\\eclipse-workspace\\aadhirai-zsgs-servlet-project\\src\\main\\webapp\\dashboard.json");
////		writer.print("");
////		writer.close();
//		
//		
//		// writing json array into json file
//		FileWriter file = new FileWriter("C:\\Users\\dhili\\eclipse-workspace\\aadhirai-zsgs-servlet-project\\src\\main\\webapp\\dashboard.json");
////		file.write(jsonString.toString());
//		file.write(dashboardDetails.toString());
////		file.flush();
//	}

}
