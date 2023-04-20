package com.zsgs.socialnetworkapplication.account.profile;

import java.util.Scanner;

public class ProfileView implements ProfileControllerViewCallBack {
    private Scanner scanner = new Scanner(System.in);
    private ProfileViewControllerCallBack profileController;

    public ProfileView(){
        profileController = new ProfileController(this);
    }

    public void viewProfilePage(String user) {
        System.out.println("Enter bio for your profile : ");
        String bio = scanner.next();
        profileController.setBio(user,bio);
        profileController.getProfilePage(user);
    }

    public void showProfilePage(String profileInfo) {
        System.out.println(profileInfo);
    }
}
