package com.zsgs.crm.accounts;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountsController implements AccountsViewControllerCallBack {

	private AccountsModel accountsModel;
	private AccountsView accountsView;
	
	public AccountsController(AccountsView accountsView) {
		this.accountsView = accountsView;
		accountsModel = new AccountsModel(this);
	}

	public void validateAccountsCredentials(String userName, String password) {
		accountsModel.validateAccountsCredentials(userName,password);
	}

	public void accountsLoginSuccess() {
		accountsView.accountsLoginSuccess();
	}

	public void accountsLoginFailure() {
		accountsView.accountsLoginFailure();
	}

	public void getLeads() {
		accountsModel.getLeads();
	}

	public void noLeadsAvailable() {
		accountsView.noLeadsAvailable();
	}

	public void showLeads(HashMap<String, String> leads) {
		accountsView.showLeads(leads);
	}

	public void callLead(String mobileNumber) {
		accountsModel.callLead(mobileNumber);
	}

	public void getContacts() {
		accountsModel.getContacts();
	}

	public void showContacts(ArrayList<ArrayList> contactDetails) {
		accountsView.showContacts(contactDetails);
	}

	public void noContactsAvailable() {
		accountsView.noContactsAvailable();
	}

}
