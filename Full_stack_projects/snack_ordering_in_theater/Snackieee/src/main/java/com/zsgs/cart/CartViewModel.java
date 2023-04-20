package com.zsgs.cart;

import java.util.List;

import com.zsgs.model.CartItems;
import com.zsgs.repository.Repository;

public class CartViewModel {

	public static CartViewModel cartViewModel;

	private CartViewModel() {}

	public static CartViewModel getInstance() {
			if (cartViewModel == null) {
				cartViewModel = new CartViewModel();
			}
		return cartViewModel;
	}
	
	public List<CartItems> getCartItems(String mailId) {
		List<CartItems> cartList = Repository.getInstance().getCartItems(mailId);
		return cartList;
	}
	
	public boolean addToCart(String mailid , int snackid , int itemCount) {
		boolean isItemAdded = Repository.getInstance().addItemsToCart(mailid,snackid,itemCount);
		return isItemAdded;
	}
	
	public boolean removeFromCart(String mailid , int snackid) {
		Repository.getInstance().removeFromCart(mailid,snackid);
		return true;
	}
}
