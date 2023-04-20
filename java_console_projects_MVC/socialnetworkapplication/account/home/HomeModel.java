package com.zsgs.socialnetworkapplication.account.home;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class HomeModel implements HomeControllerModelCallBack{
    private HomeModelControllerCallBack homeController;
    public HomeModel(HomeController homeController) {
        this.homeController = homeController;
    }

    public void getFriendsPosts(String user) {
        ArrayList<String> allPosts = SocialNetworkRepository.getInstance().getFriendsPost(user);
        if(allPosts == null)
            homeController.noPostsAvailable("No Posts available to show");
        else
            homeController.showPosts(allPosts);
    }

    public void addComment(String comment) {
        SocialNetworkRepository.getInstance().addComment(comment);
    }

    public void addLikes() {
        SocialNetworkRepository.getInstance().addLikes();
    }
}
