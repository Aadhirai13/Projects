package com.zsgs.socialnetworkapplication.account.notification;

import java.util.ArrayList;

public class NotificationController implements NotificationViewControllerCallBack , NotificationModelControllerCallBack{
    private NotificationControllerViewCallBack notificationView;
    private NotificationControllerModelCallBack notificationModel;
    public NotificationController(NotificationView notificationView) {
        this.notificationView = notificationView;
        notificationModel = new NotificationModel(this);
    }

    public void viewNotificationPage(String user) {
        notificationModel.viewNotificationPage(user);
    }

    public void sendNotifications(ArrayList<String> friendRequestNotifications) {
        notificationView.sendNotifications(friendRequestNotifications);
    }

    public void noNotifications() {
        notificationView.noNotifications();
    }

    public void acceptRequest(String friend) {
        notificationModel.acceptRequest(friend);
    }

    public void rejectRequest(String friend) {
        notificationModel.rejectRequest(friend);
    }
}
