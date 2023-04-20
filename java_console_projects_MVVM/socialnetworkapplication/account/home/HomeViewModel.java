package com.zsgs.mvvm.socialnetworkapplication.account.home;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class HomeViewModel {
    private HomeView homeView;
    public HomeViewModel(HomeView homeView) {
        this.homeView = homeView;
    }

    public void getFriendsPosts(String user) {
        ArrayList<String> allPosts = SocialNetworkRepository.getInstance().getFriendsPost(user);
        if(allPosts == null)
            homeView.noPostsAvailable("No Posts available to show");
        else
            homeView.showPosts(allPosts);
    }

    public void addComment(String comment) {
        SocialNetworkRepository.getInstance().addComment(comment);
    }

    public void addLikes() {
        SocialNetworkRepository.getInstance().addLikes();
    }
}
