package com.zsgs.socialnetworkapplication.account.home;

import java.util.ArrayList;

public interface HomeModelControllerCallBack {
    void noPostsAvailable(String noPostsAvailableToShow);

    void showPosts(ArrayList<String> allPosts);
}
