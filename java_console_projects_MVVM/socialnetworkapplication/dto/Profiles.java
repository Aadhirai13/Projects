package com.zsgs.mvvm.socialnetworkapplication.dto;

import java.util.ArrayList;

public class Profiles {
    private String userName;
    private String bio;
    private ArrayList<String> posts;

    public Profiles(String userName , int postCount, int friendsCount, ArrayList<String> posts) {
        setUserName(userName);
        setPosts(posts);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        if(bio == null)
            bio = "";
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<String> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<String> posts) {
        this.posts = posts;
    }
}
