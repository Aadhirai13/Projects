package com.zsgs.socialnetworkapplication.account.createpost;

public interface CreatePostControllerModelCallBack {
    void createPost(String user, int postID, String content, String[] hashTags);
}
