package com.zsgs.mvvm.socialnetworkapplication.account.createpost;

import java.util.Scanner;

public class CreatePostsView {
    private Scanner scanner = new Scanner(System.in);
    private CreatePostViewModel createPostViewModel;
    public CreatePostsView() {
        createPostViewModel = new CreatePostViewModel(this);
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
        createPostViewModel.createPost(user,postID,content,hashTags);
    }

    public void postCreatedSuccess(String postAttributes) {
        System.out.println(postAttributes);
        System.out.println("---------- Posted Successfully ----------");
    }
}
