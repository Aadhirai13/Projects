package com.zsgs.socialnetworkapplication.createnewaccount;

public class CreateNewAccountController implements CreateNewAccountViewControllerCallBack , CreateNewAccountModelControllerCallBack {
    private CreateNewAccountControllerViewCallBack createNewAccountView;
    private CreateNewAccountControllerModelCallBack createNewAccountModel;
    public CreateNewAccountController(CreateNewAccountView createNewAccountView) {
        this.createNewAccountView = createNewAccountView;
        createNewAccountModel = new CreateNewAccountModel(this);
    }

    public void createAccount(String userName, String password) {
        createNewAccountModel.createAccount(userName,password);
    }
    public void createAccountSuccess(){
        createNewAccountView.createAccountSuccess();
    }
    public void createAccountFailure(){
        createNewAccountView.createAccountFailure();
    }
}
