package com.zsgs.socialnetworkapplication.account.home;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeView implements HomeControllerViewCallBack {
    private HomeViewControllerCallBack homeController;
    private Scanner scanner = new Scanner(System.in);
    public HomeView(){
        homeController = new HomeController(this);
    }
    public void viewHomePage(String user){
        homeController.getFriendsPosts(user);
    }

    public void noPostsAvailable(String noPostsAvailableToShow) {
        System.out.println(noPostsAvailableToShow);
    }

    public void showPosts(ArrayList<String> allPosts) {
        for (String post : allPosts){
            System.out.println(post);
            int choice = 0;
            boolean flag;
            do {
                try {
                    System.out.println("1. LIKE\t2. COMMENT");
                    choice = scanner.nextInt();
                    if(choice < 1 || choice > 3)
                        throw new Exception("");
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Enter only integer value between 1 to 3..");
                    scanner.next();
                    flag = true;

                }
            }while (flag);
            switch (choice){
                case 1:
                {
                    System.out.println("Liked");
                    homeController.addLikes();
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Comment");
                    String comment = scanner.next();
                    homeController.addComment(comment);
                }
            }
        }
    }
}
