package com.zsgs.socialnetworkapplication.account.profile;

public class ProfileController implements ProfileViewControllerCallBack ,ProfileModelControllerCallBack {
    private ProfileControllerViewCallBack profileView;
    private ProfileControllerModelCallBack profileModel;
    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
        profileModel = new ProfileModel(this);
    }

    public void getProfilePage(String user) {
        profileModel.getProfilePage(user);
    }

    public void showProfilePage(String profileInfo) {
        profileView.showProfilePage(profileInfo);
    }

    public void setBio(String user ,String bio) {
        profileModel.setBio(user,bio);
    }
}
