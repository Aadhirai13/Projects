package com.zsgs.mvvm.socialnetworkapplication.createnewaccount;

import com.zsgs.mvvm.socialnetworkapplication.repository.SocialNetworkRepository;

public class CreateNewAccountViewModel {
    private CreateNewAccountsView createNewAccountView;
    public CreateNewAccountViewModel(CreateNewAccountsView createNewAccountView) {
        this.createNewAccountView = createNewAccountView;
    }

    public void createAccount(String userName, String password) {
        if(SocialNetworkRepository.getInstance().createAccount(userName,password)){
            createNewAccountView.createAccountSuccess();
        }
        else{
            createNewAccountView.createAccountFailure();
        }
    }
}
