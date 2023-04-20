package com.zsgs.socialnetworkapplication.account.home;

import java.util.ArrayList;

public interface HomeControllerViewCallBack {
    void noPostsAvailable(String noPostsAvailableToShow);

    void showPosts(ArrayList<String> allPosts);
}
