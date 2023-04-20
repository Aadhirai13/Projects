package com.zsgs.socialnetworkapplication.account.notification;

public interface NotificationViewControllerCallBack {
    void viewNotificationPage(String user);

    void acceptRequest(String s);

    void rejectRequest(String s);
}
