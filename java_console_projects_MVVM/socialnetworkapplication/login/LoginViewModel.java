package com.zsgs.mvvm.socialnetworkapplication.login;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

public class LoginViewModel {
    private LoginView loginView;
    public LoginViewModel(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String userName, String password) {
        String user = SocialNetworkRepository.getInstance().login(userName,password);
        if(user == "")
            loginView.loginFailure();
        else
            loginView.loginSuccess(user);
    }
}
