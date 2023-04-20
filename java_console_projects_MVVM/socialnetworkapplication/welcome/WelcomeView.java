package com.zsgs.mvvm.socialnetworkapplication.welcome;

import com.zsgs.mvvm.socialnetworkapplication.createnewaccount.CreateNewAccountsView;
import com.zsgs.mvvm.socialnetworkapplication.login.LoginView;

import java.util.Scanner;

public class WelcomeView {
    private Scanner scanner = new Scanner(System.in);
    private CreateNewAccountsView createNewAccountView;
    private LoginView loginView;

    public WelcomeView(){
        createNewAccountView = new CreateNewAccountsView();
        loginView = new LoginView();
    }

    static public void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.viewWelcomeDetails();
    }

    public void viewWelcomeDetails(){
        System.out.println("---------- Helllooo !!! ----------");
        while (true){
            int choice = 0;
            boolean flag;
            do {
                try {
                    System.out.println("If you already have an account press 1 to login \nIf you are a new user press 2 to create an account");
                    choice = scanner.nextInt();
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Enter only integer value..");
                    scanner.next();
                    flag = true;
                }
            }while (flag);

            switch (choice){
                case 1:
                {
                    loginView.viewLoginAccount();
                    break;
                }
                case 2:
                {
                    createNewAccountView.viewCreateNewAccount();
                    break;
                }
                default:
                {
                    System.out.println("Enter correct option ( 1 or 2 )");
                }
            }
        }
    }
}
