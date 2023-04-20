package com.zsgs.crm.accounts;

import java.util.ArrayList;
import java.util.HashMap;

import com.zsgs.crm.repository.CrmRepository;

public class AccountsModel {
	private AccountsController accountsController;

	public AccountsModel(AccountsController accountsController) {
		this.accountsController = accountsController;
	}

	public void validateAccountsCredentials(String userName, String password) {
		boolean isValid = CrmRepository.getInstance().validateAccountsCredentials(userName,password);
		if(isValid) {
			CrmRepository.getInstance().updateContacts();
			accountsController.accountsLoginSuccess();
		}
		else
			accountsController.accountsLoginFailure();
	}

	public void getLeads() {
		HashMap<String,String> leads = CrmRepository.getInstance().getLeads();
		if(leads.isEmpty()) {
			accountsController.noLeadsAvailable();
		}
		else {
			accountsController.showLeads(leads);
		}
	}

	public void callLead(String mobileNumber) {
		CrmRepository.getInstance().callLead(mobileNumber);
	}

	public void getContacts() {
		ArrayList<ArrayList> contactDetails = CrmRepository.getInstance().getContacts();
		if(contactDetails.isEmpty()) {
			accountsController.noContactsAvailable();
		}
		else {
			accountsController.showContacts(contactDetails);
		}
	}

}
