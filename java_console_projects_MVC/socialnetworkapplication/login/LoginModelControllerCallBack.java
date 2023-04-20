package com.zsgs.socialnetworkapplication.login;

public interface LoginModelControllerCallBack {
    void loginFailure();

    void loginSuccess(String user);
}
