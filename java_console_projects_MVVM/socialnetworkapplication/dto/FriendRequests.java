package com.zsgs.mvvm.socialnetworkapplication.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class FriendRequests {
    private String userName;
    private ArrayList<String> friendList;
    private ArrayList<Boolean> isFriend;
    private ArrayList<Boolean> isRequestSent;
    public FriendRequests(String userName, String[] friendList, Boolean[] isFriend, Boolean[] isRequestSent) {
        setUserName(userName);
        setFriendList(new ArrayList<>(Arrays.asList(friendList)));
        setIsFriend(new ArrayList<>(Arrays.asList(isFriend)));
        setIsRequestSent(new ArrayList<>(Arrays.asList(isRequestSent)));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Boolean> isFriend() {
        return isFriend;
    }

    public void setIsFriend(ArrayList<Boolean> isFriend) {
        this.isFriend = isFriend;
    }

    public ArrayList<Boolean> isRequestSent() {
        return isRequestSent;
    }
    public void setIsRequestSent(ArrayList<Boolean> isRequestSent) {
        this.isRequestSent = isRequestSent;
    }

}
