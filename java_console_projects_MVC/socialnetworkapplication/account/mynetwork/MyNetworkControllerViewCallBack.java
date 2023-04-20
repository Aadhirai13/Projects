package com.zsgs.socialnetworkapplication.account.mynetwork;

import java.util.ArrayList;

public interface MyNetworkControllerViewCallBack {
    void showMyNetwork(String myNetwork);

    void viewRequestsSent(ArrayList<String> friendRequestSentNotifications);

    void noRequestsSent();

    void viewMembers(String user, ArrayList<String> members);
}
