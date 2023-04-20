package com.zsgs.mvvm.socialnetworkapplication.account.notification;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class NotificationViewModel  {
    private NotificationsView notificationView;
    public NotificationViewModel(NotificationsView notificationView) {
        this.notificationView = notificationView;
    }

    public void viewNotificationPage(String user) {
        ArrayList<String> friendRequestNotifications = SocialNetworkRepository.getInstance().getNotifications(user);
        if(friendRequestNotifications != null)
            notificationView.sendNotifications(friendRequestNotifications);
        else
            notificationView.noNotifications();
    }

    public void acceptRequest(String friend) {
        String user = SocialNetworkRepository.getInstance().getUserName();
        SocialNetworkRepository.getInstance().acceptRequest(user,friend);
    }

    public void rejectRequest(String friend) {
        String user = SocialNetworkRepository.getInstance().getUserName();
        SocialNetworkRepository.getInstance().rejectRequest(user,friend);
    }
}
