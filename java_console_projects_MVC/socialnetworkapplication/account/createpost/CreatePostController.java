package com.zsgs.socialnetworkapplication.account.createpost;

public class CreatePostController implements CreatePostViewControllerCallBack , CreatePostModelControllerCallBack {
    private CreatePostControllerViewCallBack createPostView;
    private CreatePostControllerModelCallBack createPostModel;
    public CreatePostController(CreatePostView createPostView) {
        this.createPostView = createPostView;
        createPostModel = new CreatePostModel(this);
    }

    public void createPost(String user ,int postID, String content, String[] hashTags) {
        createPostModel.createPost(user , postID,content,hashTags);
    }

    public void postCreatedSuccess(String postAttributes) {
        createPostView.postCreatedSuccess(postAttributes);
    }
}
