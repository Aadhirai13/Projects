package com.zsgs.crm;

import java.util.Scanner;

import com.zsgs.crm.accounts.AccountsView;
import com.zsgs.crm.users.UsersView;

public class WelcomeView {
	private Scanner scanner = new Scanner(System.in);
	private AccountsView accountsView;
	private UsersView usersView;
	
	public WelcomeView() {
		accountsView = new AccountsView();
		usersView = new UsersView();
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub

		WelcomeView welcomeView = new WelcomeView();
		System.out.println("----- WELCOME TO XYZ CRM -----");
		welcomeView.showWelcomeScreen();
	}

	public void showWelcomeScreen(){
		System.out.println("1.Accounts Login\t\t2.User Login\t\t3.User Sign-Up");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:{
			accountsView.viewAccountsLogin();
			break;
		}
		case 2:{
			usersView.viewUsersLogin();
			break;
		}
		case 3:{
			usersView.viewUsersSignup();
			break;
		}
		default:{
			System.out.println("Enter valid choice");
			showWelcomeScreen();
			break;
		}
		}
	}

}
