package com.zsgs.socialnetworkapplication.account.createpost;

public interface CreatePostViewControllerCallBack {
    void createPost(String user, int postID, String content, String[] hashTags);
}
