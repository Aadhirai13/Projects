package com.zsgs.mvvm.socialnetworkapplication.account;

import com.zsgs.mvvm.socialnetworkapplication.account.createpost.CreatePostsView;
import com.zsgs.mvvm.socialnetworkapplication.account.home.HomeView;
import com.zsgs.mvvm.socialnetworkapplication.account.mynetwork.MyNetworksView;
import com.zsgs.mvvm.socialnetworkapplication.account.notification.NotificationsView;
import com.zsgs.mvvm.socialnetworkapplication.account.profile.ProfilesView;
import com.zsgs.mvvm.socialnetworkapplication.welcome.WelcomeView;

import java.util.Scanner;

public class AccountView {
    private Scanner scanner = new Scanner(System.in);
    private CreatePostsView createPostView;
    private HomeView homeView;
    private MyNetworksView myNetworkView;
    private NotificationsView notificationView;
    private ProfilesView profileView;
    public AccountView(){
        homeView = new HomeView();
        myNetworkView = new MyNetworksView();
        createPostView = new CreatePostsView();
        notificationView = new NotificationsView();
        profileView = new ProfilesView();
    }

    public void viewAccountNavigations(String user){
        while (true){
            int choice = 0;
            boolean flag;
            do {
                try {
                    System.out.println("---------- Navigations ----------");
                    System.out.println("1. Home \n2. My Network \n3. Create Post \n4. Notifications \n5. Profile \n6. Logout from application");
                    choice = scanner.nextInt();
                    if(choice < 1 || choice > 6)
                        throw new Exception("");
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Enter only integer value between 1 to 6..");
                    scanner.next();
                    flag = true;

                }
            }while (flag);

            switch (choice){
                case 1:
                {
                    homeView.viewHomePage(user);
                    break;
                }
                case 2:
                {
                    //done
                    myNetworkView.viewMyNetworkPage(user);
                    break;
                }
                case 3:
                {
                    //done
                    createPostView.viewCreatePostPage(user);
                    break;
                }
                case 4:
                {
                    //done
                    notificationView.viewNotificationPage(user);
                    break;
                }
                case 5:
                {
                    //done
                    profileView.viewProfilePage(user);
                    break;
                }
                case 6:
                {
                    WelcomeView welcomeView = new WelcomeView();
                    welcomeView.viewWelcomeDetails();
                }
            }
        }
    }
}
