package com.zsgs.mvvm.socialnetworkapplication.account.mynetwork;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class MyNetworkViewModel {
    private MyNetworksView myNetworkView;
    public MyNetworkViewModel(MyNetworksView myNetworkView) {
        this.myNetworkView = myNetworkView;
    }

    public void viewMyNetwork(String user) {
        String myNetwork = SocialNetworkRepository.getInstance().getNetwork(user);
        if(myNetwork == "")
            myNetworkView.showMyNetwork("No Friends added yet ... ");
        else
            myNetworkView.showMyNetwork(myNetwork);
    }

    public void getRequestSent(String user) {
        ArrayList<String> friendRequestSentNotifications = SocialNetworkRepository.getInstance().getRequestSent(user);
        if(friendRequestSentNotifications != null)
            myNetworkView.viewRequestsSent(friendRequestSentNotifications);
        else
            myNetworkView.noRequestsSent();
    }

    public void getMembers(String user) {
        ArrayList<String> members = SocialNetworkRepository.getInstance().getMembers(user);
        myNetworkView.viewMembers(user,members);
    }

    public void giveFriendRequest(String user,String member) {
        SocialNetworkRepository.getInstance().giveFriendRequest(user,member);
    }
}
