package com.zsgs.socialnetworkapplication.account;

import com.zsgs.socialnetworkapplication.account.createpost.CreatePostView;
import com.zsgs.socialnetworkapplication.account.home.HomeView;
import com.zsgs.socialnetworkapplication.account.mynetwork.MyNetworkView;
import com.zsgs.socialnetworkapplication.account.notification.NotificationView;
import com.zsgs.socialnetworkapplication.account.profile.ProfileView;
import com.zsgs.socialnetworkapplication.welcome.WelcomeView;

import java.util.Scanner;

public class AccountView {
    private Scanner scanner = new Scanner(System.in);
    private CreatePostView createPostView;
    private HomeView homeView;
    private MyNetworkView myNetworkView;
    private NotificationView notificationView;
    private ProfileView profileView;
    public AccountView(){
        homeView = new HomeView();
        myNetworkView = new MyNetworkView();
        createPostView = new CreatePostView();
        notificationView = new NotificationView();
        profileView = new ProfileView();
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
