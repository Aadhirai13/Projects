package com.zsgs.socialnetworkapplication.account.createpost;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

public class CreatePostModel implements CreatePostControllerModelCallBack {
    private CreatePostModelControllerCallBack createPostController;
    public CreatePostModel(CreatePostController createPostController) {
        this.createPostController = createPostController;
    }

    public void createPost(String user, int postID, String content, String[] hashTags) {
        String postAttributes = SocialNetworkRepository.getInstance().createPost(user,postID,content,hashTags);
        createPostController.postCreatedSuccess(postAttributes);

    }
}
