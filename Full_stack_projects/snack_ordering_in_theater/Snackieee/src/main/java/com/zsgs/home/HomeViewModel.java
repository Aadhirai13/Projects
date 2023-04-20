package com.zsgs.home;

import java.util.List;

import com.zsgs.model.Categories;
import com.zsgs.model.SnackDetails;
import com.zsgs.repository.Repository;

public class HomeViewModel {

	public static HomeViewModel homeViewModel;

	private HomeViewModel() {}

	public static HomeViewModel getInstance() {
			if (homeViewModel == null) {
				homeViewModel = new HomeViewModel();
			}
		return homeViewModel;
	}
	
	public List<Categories> getCategories(){
		List<Categories> catList = Repository.getInstance().getCategories();
		return catList;
	}
	
	public List<SnackDetails> getSnacks(int categoryId){
		List<SnackDetails> snackList = Repository.getInstance().getSnackItems(categoryId);
		return snackList;
	}
	
	public SnackDetails getIndividualSnack(int snackId) {
		SnackDetails snack = Repository.getInstance().getSnackDetail(snackId);
		return snack;
	}

	public List<SnackDetails> getSearchSnacks(String searchkeyword) {
		List<SnackDetails> snackList = Repository.getInstance().getSearchSnackItems(searchkeyword);
		return snackList;
	}
}
