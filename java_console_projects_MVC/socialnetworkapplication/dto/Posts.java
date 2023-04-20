package com.zsgs.socialnetworkapplication.dto;

import java.util.ArrayList;

public class Posts {
    private String user;
    private int postID;
    private String content;
    private String[] hashTags;
    private int likeCount;
    private ArrayList<String> comments;

    public Posts(String user, int postID, String content, String[] hashTags, int likeCount, ArrayList<String> comments) {
        setUser(user);
        setContent(content);
        setHashTags(hashTags);
        setPostID(postID);
        setLikeCount(likeCount);
        setComments(comments);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getHashTags() {
        return hashTags;
    }

    public void setHashTags(String[] hashTags) {
        this.hashTags = hashTags;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
