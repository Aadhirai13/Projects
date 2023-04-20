package com.zsgs.socialnetworkapplication.account.mynetwork;

import java.util.ArrayList;

public interface MyNetworkModelControllerCallBack {
    void showMyNetwork(String s);

    void viewRequestsSent(ArrayList<String> friendRequestSentNotifications);

    void noRequestsSent();

    void viewMembers(String user, ArrayList<String> members);
}
