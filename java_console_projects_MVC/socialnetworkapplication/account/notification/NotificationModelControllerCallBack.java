package com.zsgs.socialnetworkapplication.account.notification;

import java.util.ArrayList;

public interface NotificationModelControllerCallBack {
    void sendNotifications(ArrayList<String> friendRequestNotifications);

    void noNotifications();
}
