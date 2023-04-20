package com.zsgs.socialnetworkapplication.account.home;

public interface HomeControllerModelCallBack {
    void getFriendsPosts(String user);

    void addComment(String comment);

    void addLikes();
}
