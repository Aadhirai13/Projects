package com.zsgs.account;

import com.zsgs.repository.Repository;

public class AccountViewModel {
	public static AccountViewModel accountViewModel;

	private AccountViewModel() {}

	public static AccountViewModel getInstance() {
			if (accountViewModel == null) {
				accountViewModel = new AccountViewModel();
			}
		return accountViewModel;
	}
	
	public boolean addUser(String username , String email , String password) {
		return Repository.getInstance().addUser(username,email,password);
	}
	
	public boolean userLogin(String email , String password) {
		return Repository.getInstance().validateUserCredentials(email, password);
	}
	
	public boolean addSnacks(int category_id, String snack_name, float price, int stock, String quantity, String snack_image) {
		Repository.getInstance().addSnacks(category_id,snack_name,price,stock,quantity,snack_image);
		return true;
	}
}
