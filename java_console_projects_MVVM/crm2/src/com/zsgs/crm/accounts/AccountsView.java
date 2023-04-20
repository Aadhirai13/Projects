package com.zsgs.crm.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.zsgs.crm.WelcomeView;

public class AccountsView {

	private Scanner scanner = new Scanner(System.in);
	private AccountsViewModel accountsViewModel;

	public AccountsView() {
		accountsViewModel = new AccountsViewModel(this);
	}

	public void viewAccountsLogin() {
		System.out.println("----- ACCOUNTS LOGIN -----");
		System.out.println("Enter user name:");
		String userName = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		accountsViewModel.validateAccountsCredentials(userName, password);
	}

	public void accountsLoginSuccess() {
		System.out.println("----- Accounts Logged In successfully -----");
		outer: while (true) {
			System.out.println("1.Show Leads\t2.Show Contacts\t3.Logout");
			String choice = scanner.next();
			switch (choice) {
			case "1": {
				accountsViewModel.getLeads();
				break;
			}
			case "2": {
				accountsViewModel.getContacts();
				break;
			}
			case "3": {
				new WelcomeView().showWelcomeScreen();
				break outer;
			}
			default: {
				continue outer;
			}
			}
		}
	}

	public void accountsLoginFailure() {
		System.out.println("----- Invalid Accounts Credentials. Login Again -----");
		viewAccountsLogin();
	}

	public void noLeadsAvailable() {
		System.out.println("----- Currently No Leads Available To Show -----");
	}

	public void showLeads(HashMap<String, String> leads) {
		for(Map.Entry<String,String> entrySet : leads.entrySet()) {
			System.out.println("Lead - " + entrySet.getValue());
			System.out.println("Contact - " + entrySet.getKey());
			System.out.println("1.Call Lead\t2.Show Next Lead");
			String choice = scanner.next();
			if(choice.equals("1")) {
				accountsViewModel.callLead(entrySet.getKey());
			}
			else {
				continue;
			}
		}
	}

	public void noContactsAvailable() {
		System.out.println("----- Currently No Contacts Available To Show -----");
	}

	public void showContacts(ArrayList<ArrayList> contactDetails) {
		for(ArrayList contacts : contactDetails) {
			System.out.println("----------------------------------------------");
			System.out.println("User Name - " + contacts.get(0));
			System.out.println("Mobile Number - " + contacts.get(1));
			System.out.println("Location - " + contacts.get(2));
			System.out.println("Account Number - " + contacts.get(3));
			System.out.println("Loan Amount - " + contacts.get(4));
			System.out.println("Monthly Interest Percent - " + contacts.get(5) + "%");
			System.out.println("Monthly Interest Amount - " + contacts.get(6));
			System.out.println("Individual Profit Percent - " + contacts.get(7));
		}
	}
}
