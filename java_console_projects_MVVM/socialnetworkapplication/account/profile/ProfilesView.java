package com.zsgs.mvvm.socialnetworkapplication.account.profile;

import java.util.Scanner;

public class ProfilesView {
    private Scanner scanner = new Scanner(System.in);
    private ProfileViewModel profileViewModel;

    public ProfilesView(){
        profileViewModel = new ProfileViewModel(this);
    }

    public void viewProfilePage(String user) {
        System.out.println("Enter bio for your profile : ");
        String bio = scanner.next();
        profileViewModel.setBio(user,bio);
        profileViewModel.getProfilePage(user);
    }

    public void showProfilePage(String profileInfo) {
        System.out.println(profileInfo);
    }
}
