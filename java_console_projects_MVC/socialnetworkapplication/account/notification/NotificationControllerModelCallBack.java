package com.zsgs.socialnetworkapplication.account.notification;

public interface NotificationControllerModelCallBack {
    void viewNotificationPage(String user);

    void acceptRequest(String friend);

    void rejectRequest(String friend);
}
