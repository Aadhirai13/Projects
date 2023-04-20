package com.zsgs.socialnetworkapplication.account.mynetwork;

public interface MyNetworkViewControllerCallBack {
    void getMembers(String user);

    void viewMyNetwork(String user);

    void getRequestSent(String user);

    void giveFriendRequest(String user, String member);
}
