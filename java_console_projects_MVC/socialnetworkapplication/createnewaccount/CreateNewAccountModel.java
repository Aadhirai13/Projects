package com.zsgs.socialnetworkapplication.createnewaccount;
import com.zsgs.socialnetworkapplication.repository.SocialNetworkRepository;

public class CreateNewAccountModel implements CreateNewAccountControllerModelCallBack {
    private CreateNewAccountModelControllerCallBack createNewAccountController;
    public CreateNewAccountModel(CreateNewAccountController createNewAccountController) {
        this.createNewAccountController = createNewAccountController;
    }

    public void createAccount(String userName, String password) {
        if(SocialNetworkRepository.getInstance().createAccount(userName,password)){
            createNewAccountController.createAccountSuccess();
        }
        else{
            createNewAccountController.createAccountFailure();
        }
    }
}
