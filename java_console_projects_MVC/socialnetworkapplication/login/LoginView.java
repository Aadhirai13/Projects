package com.zsgs.socialnetworkapplication.login;

import com.zsgs.socialnetworkapplication.account.AccountView;

import java.util.Scanner;

public class LoginView implements LoginControllerViewCallBack{
    private Scanner scanner = new Scanner(System.in);
    private LoginViewControllerCallBack loginController;
    private AccountView accountView;
    public LoginView(){
        loginController = new LoginController(this);
        accountView = new AccountView();
    }
    public void viewLoginAccount(){
        System.out.println("---------- Login ----------");
        System.out.println("Enter user name");
        String userName = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        loginController.login(userName,password);
    }
    public void loginFailure() {
        System.out.println("Invalid username or password");
        viewLoginAccount();
    }
    public void loginSuccess(String user) {
        System.out.println("---------- Hi " + user + " !!! ----------");
        accountView.viewAccountNavigations(user);
    }
}
