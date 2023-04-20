package com.zsgs.socialnetworkapplication.account.mynetwork;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class MyNetworkModel implements MyNetworkControllerModelCallBack{
    private MyNetworkModelControllerCallBack myNetworkController;
    public MyNetworkModel(MyNetworkController myNetworkController) {
        this.myNetworkController = myNetworkController;
    }

    public void viewMyNetwork(String user) {
        String myNetwork = SocialNetworkRepository.getInstance().getNetwork(user);
        if(myNetwork == "")
            myNetworkController.showMyNetwork("No Friends added yet ... ");
        else
            myNetworkController.showMyNetwork(myNetwork);
    }

    public void getRequestSent(String user) {
        ArrayList<String> friendRequestSentNotifications = SocialNetworkRepository.getInstance().getRequestSent(user);
        if(friendRequestSentNotifications != null)
            myNetworkController.viewRequestsSent(friendRequestSentNotifications);
        else
            myNetworkController.noRequestsSent();
    }

    public void getMembers(String user) {
        ArrayList<String> members = SocialNetworkRepository.getInstance().getMembers(user);
        myNetworkController.viewMembers(user,members);
    }

    public void giveFriendRequest(String user,String member) {
        SocialNetworkRepository.getInstance().giveFriendRequest(user,member);
    }
}
