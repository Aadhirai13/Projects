package com.zsgs.mvvm.socialnetworkapplication.account.createpost;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

public class CreatePostViewModel {
    private CreatePostsView createPostView;
    public CreatePostViewModel(CreatePostsView createPostView) {
        this.createPostView = createPostView;
    }

    public void createPost(String user, int postID, String content, String[] hashTags) {
        String postAttributes = SocialNetworkRepository.getInstance().createPost(user,postID,content,hashTags);
        createPostView.postCreatedSuccess(postAttributes);

    }
}
