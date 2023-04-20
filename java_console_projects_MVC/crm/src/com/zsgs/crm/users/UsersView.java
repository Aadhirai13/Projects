package com.zsgs.crm.users;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zsgs.crm.WelcomeView;

public class UsersView implements UsersControllerViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private UsersViewControllerCallBack usersController;
	
	public UsersView() {
		usersController = new UsersController(this);
	}

	public void viewUsersLogin(){
		System.out.println("----- USER LOGIN -----");
		System.out.println("Enter user name:");
		String userName = scanner.next();
		System.out.println("Enter mobile number:");
		String mobileNumber = scanner.next();
		usersController.validateUserCredentials(userName,mobileNumber);
	}

	public void viewUsersSignup() {
		// TODO Auto-generated method stub
		System.out.println("----- USER SIGN-UP -----");
		System.out.println("Enter user name:");
		String userName = scanner.next();
		System.out.println("Enter mobile number:");
		String mobileNumber = scanner.next();
//		validateMobileNumber(mobileNumber);
		usersController.userSignUp(userName,mobileNumber);
	}

	private void validateMobileNumber(String mobileNumber) {
		Pattern p = Pattern.compile("[6-9][0-9]9");
		Matcher m = p.matcher(mobileNumber);
		if(!m.matches()) {
			System.out.println("Invalid phone number...Please enter your details again");
			viewUsersSignup();
		}
	}

	public void loginSuccess(String string) {
		System.out.println(string);
		viewUsersLogin();
	}
	
	public void loginFailure(String string) {
		System.out.println(string);
		new WelcomeView().showWelcomeScreen();
	}

	public void showCallDetails(ArrayList<Integer> callDetails,String userName,String mobileNumber) {
		System.out.println("----- Call Details -----");
		int minimumLoanAmount = callDetails.get(0);
		int monthlyInterestPercent = callDetails.get(1);
		System.out.println("Minimum Loan Amount - " + minimumLoanAmount + "\nMonthly Interest Percent - " + monthlyInterestPercent);
		System.out.println("1.ACCEPT\t2.REJECT");
		String choice = scanner.next();
		if(choice.equals("1")) {
			getContactDetails(userName,mobileNumber,minimumLoanAmount,monthlyInterestPercent);
		}
		else {
			logout();
		}
	}

	private void getContactDetails(String userName, String mobileNumber,int minimumLoanAmount,int monthlyInterestPercent) {
		System.out.println("Enter your location - ");
		String location = scanner.next();
		System.out.println("Enter your Account Number - ");
		String accountNumber = scanner.next();
		int loanAmount = 0;
		while(loanAmount < minimumLoanAmount || loanAmount > 1000000) {
			System.out.println("Enter loan amount - ");
			loanAmount = scanner.nextInt();
		}
		usersController.storeContactDetails(userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent);
	}

	private void logout() {
		new WelcomeView().showWelcomeScreen();
	}

	public void dealConfirmed(float monthlyInterestAmount) {
		System.out.println("you have to pay " + monthlyInterestAmount + " monthly");
		System.out.println("----- Deal Confirmed -----");
		new WelcomeView().showWelcomeScreen();
	}

	public void noCallsYet(String string) {
		System.out.println(string);
		logout();
	}

	public void showContactDetails(ArrayList contactDetails) {
		System.out.println("Account Number - " + contactDetails.get(3));
		System.out.println("Loan Amount - " + contactDetails.get(4));
		System.out.println("Monthly Interest Percent - " + contactDetails.get(5));
		System.out.println("Monthly Interest Amount - " + contactDetails.get(6));
		logout();
	}
}
