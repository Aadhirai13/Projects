package com.zsgs.crm.accounts;

import java.util.ArrayList;
import java.util.HashMap;

import com.zsgs.crm.repository.CrmRepository;

public class AccountsViewModel {
	private AccountsView accountsView;

	public AccountsViewModel(AccountsView accountsView) {
		this.accountsView = accountsView;
	}

	public void validateAccountsCredentials(String userName, String password) {
		boolean isValid = CrmRepository.getInstance().validateAccountsCredentials(userName,password);
		if(isValid) {
			CrmRepository.getInstance().updateContacts();
			accountsView.accountsLoginSuccess();
		}
		else
			accountsView.accountsLoginFailure();
	}

	public void getLeads() {
		HashMap<String,String> leads = CrmRepository.getInstance().getLeads();
		if(leads.isEmpty()) {
			accountsView.noLeadsAvailable();
		}
		else {
			accountsView.showLeads(leads);
		}
	}

	public void callLead(String mobileNumber) {
		CrmRepository.getInstance().callLead(mobileNumber);
	}

	public void getContacts() {
		ArrayList<ArrayList> contactDetails = CrmRepository.getInstance().getContacts();
		if(contactDetails.isEmpty()) {
			accountsView.noContactsAvailable();
		}
		else {
			accountsView.showContacts(contactDetails);
		}
	}

}
