package com.zsgs.socialnetworkapplication.account.mynetwork;

import java.util.ArrayList;

public class MyNetworkController implements MyNetworkViewControllerCallBack , MyNetworkModelControllerCallBack{
    private MyNetworkControllerViewCallBack myNetworkView;
    private MyNetworkControllerModelCallBack myNetworkModel;
    public MyNetworkController(MyNetworkView myNetworkView) {
        this.myNetworkView = myNetworkView;
        myNetworkModel = new MyNetworkModel(this);
    }

    public void viewMyNetwork(String user) {
        myNetworkModel.viewMyNetwork(user);
    }

    public void showMyNetwork(String myNetwork) {
        myNetworkView.showMyNetwork(myNetwork);
    }

    public void getRequestSent(String user) {
        myNetworkModel.getRequestSent(user);
    }

    public void viewRequestsSent(ArrayList<String> friendRequestSentNotifications) {
        myNetworkView.viewRequestsSent(friendRequestSentNotifications);
    }

    public void noRequestsSent() {
        myNetworkView.noRequestsSent();
    }

    public void getMembers(String user) {
        myNetworkModel.getMembers(user);
    }

    public void viewMembers(String user,ArrayList<String> members) {
        myNetworkView.viewMembers(user,members);
    }

    public void giveFriendRequest(String user,String member) {
        myNetworkModel.giveFriendRequest(user,member);
    }
}
