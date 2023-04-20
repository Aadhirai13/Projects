package com.zsgs.socialnetworkapplication.account.notification;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

import java.util.ArrayList;

public class NotificationModel implements NotificationControllerModelCallBack {
    private NotificationModelControllerCallBack notificationController;
    public NotificationModel(NotificationController notificationController) {
        this.notificationController = notificationController;
    }

    public void viewNotificationPage(String user) {
        ArrayList<String> friendRequestNotifications = SocialNetworkRepository.getInstance().getNotifications(user);
        if(friendRequestNotifications != null)
            notificationController.sendNotifications(friendRequestNotifications);
        else
            notificationController.noNotifications();
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
