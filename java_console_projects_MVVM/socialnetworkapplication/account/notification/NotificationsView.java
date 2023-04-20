package com.zsgs.mvvm.socialnetworkapplication.account.notification;

import java.util.ArrayList;
import java.util.Scanner;

public class NotificationsView {
    private Scanner scanner = new Scanner(System.in);
    private NotificationViewModel notificationViewModel;

    public NotificationsView(){
        notificationViewModel = new NotificationViewModel(this);
    }

    public void viewNotificationPage(String user) {
        notificationViewModel.viewNotificationPage(user);
    }

    public void sendNotifications(ArrayList<String> friendRequestNotifications) {
        System.out.println("---------- Friend Requests Received " + friendRequestNotifications.size() + " ----------");

        for(int i=0;i<friendRequestNotifications.size();i++){
            System.out.println(friendRequestNotifications.get(i));
            int choice = 0;
            boolean flag;
            do {
                try {
                    System.out.println("1. ACCEPT \t 2. REJECT");
                    choice = scanner.nextInt();
                    if(choice < 1 || choice > 2)
                        throw new Exception("");
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Enter only integer value between 1 and 2..");
                    scanner.next();
                    flag = true;
                }
            } while(flag);

            switch (choice){
                case 1:
                {
                    notificationViewModel.acceptRequest(friendRequestNotifications.get(i));
                    System.out.println("Accepted");
                    break;
                }
                case 2:
                {
                    notificationViewModel.rejectRequest(friendRequestNotifications.get(i));
                    System.out.println("Rejected");
                    break;
                }
            }
        }
    }

    public void noNotifications() {
        System.out.println("---------- No Notifications !! ----------");
    }
}
