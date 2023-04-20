package com.zsgs.socialnetworkapplication.account.home;

public interface HomeViewControllerCallBack {
    void getFriendsPosts(String user);

    void addLikes();

    void addComment(String comment);
}
