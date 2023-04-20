package com.zsgs.crm.accounts;

public interface AccountsViewControllerCallBack {

	void validateAccountsCredentials(String userName, String password);

	void getLeads();

	void getContacts();

	void callLead(String key);

}
