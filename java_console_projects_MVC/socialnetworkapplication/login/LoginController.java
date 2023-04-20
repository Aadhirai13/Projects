package com.zsgs.socialnetworkapplication.login;

public class LoginController implements LoginViewControllerCallBack , LoginModelControllerCallBack{
    private LoginControllerViewCallBack loginView;
    private LoginControllerModelCallBack loginModel;
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    public void login(String userName, String password) {
        loginModel.login(userName,password);
    }

    public void loginFailure() {
        loginView.loginFailure();
    }

    public void loginSuccess(String user) {
        loginView.loginSuccess(user);
    }
}
