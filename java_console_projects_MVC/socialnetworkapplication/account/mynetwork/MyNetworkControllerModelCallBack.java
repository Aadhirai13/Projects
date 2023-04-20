package com.zsgs.socialnetworkapplication.account.mynetwork;

public interface MyNetworkControllerModelCallBack {
    void viewMyNetwork(String user);

    void getRequestSent(String user);

    void getMembers(String user);

    void giveFriendRequest(String user, String member);
}
