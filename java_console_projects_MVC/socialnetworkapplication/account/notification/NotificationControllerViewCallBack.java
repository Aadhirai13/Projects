package com.zsgs.socialnetworkapplication.account.notification;

import java.util.ArrayList;

public interface NotificationControllerViewCallBack {
    void sendNotifications(ArrayList<String> friendRequestNotifications);

    void noNotifications();
}
