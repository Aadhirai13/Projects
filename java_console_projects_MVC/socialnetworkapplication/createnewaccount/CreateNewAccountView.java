package com.zsgs.socialnetworkapplication.createnewaccount;

import com.zsgs.socialnetworkapplication.login.LoginView;

import java.util.Scanner;

public class CreateNewAccountView implements CreateNewAccountControllerViewCallBack{
    private Scanner scanner = new Scanner(System.in);
    private CreateNewAccountViewControllerCallBack createNewAccountController;
    private LoginView loginView;
    public CreateNewAccountView(){
        createNewAccountController = new CreateNewAccountController(this);
        loginView = new LoginView();
    }
    public void viewCreateNewAccount(){
        System.out.println("---------- Create New Account ----------");
        System.out.println("Enter user name");
        String userName = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        if(!confirmPassword(password)){
            System.out.println("Your password is not matching");
            confirmPassword(password);
        }
        createNewAccountController.createAccount(userName,password);
    }
    public boolean confirmPassword(String password){
        System.out.println("Re-enter password to confirm");
        String confirmPassword = scanner.next();
        return password.equals(confirmPassword);
    }
    public void createAccountSuccess(){
        System.out.println("---------- Account created successfully ----------");
        loginView.viewLoginAccount();
    }
    public void createAccountFailure(){
        System.out.println("Username is already available...Please try again");
        viewCreateNewAccount();
    }
}
