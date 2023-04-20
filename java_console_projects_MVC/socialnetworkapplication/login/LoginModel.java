package com.zsgs.socialnetworkapplication.login;

import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

public class LoginModel implements LoginControllerModelCallBack{
    private LoginModelControllerCallBack loginController;
    public LoginModel(LoginController loginController) {
        this.loginController = loginController;
    }

    public void login(String userName, String password) {
        String user = SocialNetworkRepository.getInstance().login(userName,password);
        if(user == "")
            loginController.loginFailure();
        else
            loginController.loginSuccess(user);
    }
}
