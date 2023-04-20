package com.zsgs.socialnetworkapplication.account.profile;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

public class ProfileModel implements ProfileControllerModelCallBack {
    private ProfileModelControllerCallBack profileController;
    public ProfileModel(ProfileController profileController) {
        this.profileController = profileController;
    }

    public void getProfilePage(String user) {
        String profileInfo = SocialNetworkRepository.getInstance().getProfilePageInfo(user);
        profileController.showProfilePage(profileInfo);
    }

    public void setBio(String user , String bio) {
        SocialNetworkRepository.getInstance().setBio(user, bio);
    }
}
