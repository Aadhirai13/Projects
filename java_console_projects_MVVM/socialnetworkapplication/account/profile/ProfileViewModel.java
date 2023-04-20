package com.zsgs.mvvm.socialnetworkapplication.account.profile;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

public class ProfileViewModel {
    private ProfilesView profileView;
    public ProfileViewModel(ProfilesView profileView) {
        this.profileView = profileView;
    }

    public void getProfilePage(String user) {
        String profileInfo = SocialNetworkRepository.getInstance().getProfilePageInfo(user);
        profileView.showProfilePage(profileInfo);
    }

    public void setBio(String user , String bio) {
        SocialNetworkRepository.getInstance().setBio(user, bio);
    }
}
