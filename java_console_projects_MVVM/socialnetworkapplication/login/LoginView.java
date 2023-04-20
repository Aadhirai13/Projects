package com.zsgs.mvvm.socialnetworkapplication.login;

import com.zsgs.mvvm.socialnetworkapplication.account.AccountView;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner = new Scanner(System.in);
    private LoginViewModel loginViewModel;
    private AccountView accountView;
    public LoginView(){
        loginViewModel = new LoginViewModel(this);
        accountView = new AccountView();
    }
    public void viewLoginAccount(){
        System.out.println("---------- Login ----------");
        System.out.println("Enter user name");
        String userName = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        loginViewModel.login(userName,password);
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
