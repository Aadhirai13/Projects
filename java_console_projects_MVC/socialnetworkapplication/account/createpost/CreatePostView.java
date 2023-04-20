package com.zsgs.socialnetworkapplication.account.createpost;

import java.util.Scanner;

public class CreatePostView implements CreatePostControllerViewCallBack {
    private Scanner scanner = new Scanner(System.in);
    private CreatePostViewControllerCallBack createPostController;
    public CreatePostView() {
        createPostController = new CreatePostController(this);
    }

    public void viewCreatePostPage(String user) {
        System.out.println("Enter PostID");
        int postID = scanner.nextInt();
        System.out.println("Enter Content");
        String content = scanner.next();
        System.out.println("Enter 2 HashTags");
        String[] hashTags = new String[3];
        for(int i=0;i<3;i++)
            hashTags[i] = scanner.next();
        createPostController.createPost(user,postID,content,hashTags);
    }

    public void postCreatedSuccess(String postAttributes) {
        System.out.println(postAttributes);
        System.out.println("---------- Posted Successfully ----------");
    }
}
