package com.zsgs.socialnetworkapplication.login;

public interface LoginControllerViewCallBack {
    void loginFailure();

    void loginSuccess(String user);
}
