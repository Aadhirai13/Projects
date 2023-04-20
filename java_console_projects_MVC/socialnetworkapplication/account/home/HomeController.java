package com.zsgs.socialnetworkapplication.account.home;

import java.util.ArrayList;

public class HomeController implements HomeViewControllerCallBack , HomeModelControllerCallBack {
    private HomeControllerViewCallBack homeView;
    private HomeControllerModelCallBack homeModel;
    public HomeController(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    public void getFriendsPosts(String user) {
        homeModel.getFriendsPosts(user);
    }

    public void noPostsAvailable(String noPostsAvailableToShow) {
        homeView.noPostsAvailable(noPostsAvailableToShow);
    }

    public void showPosts(ArrayList<String> allPosts) {
        homeView.showPosts(allPosts);
    }

    public void addComment(String comment) {
        homeModel.addComment(comment);
    }

    public void addLikes() {
        homeModel.addLikes();
    }
}
