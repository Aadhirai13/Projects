package com.zsgs.orders;

import java.util.List;

import com.zsgs.account.AccountViewModel;
import com.zsgs.model.OrderedItems;
import com.zsgs.model.OrderedItemsDetails;
import com.zsgs.repository.Repository;

public class OrdersViewModel {
	public static OrdersViewModel ordersViewModel;

	private OrdersViewModel() {}

	public static OrdersViewModel getInstance() {
			if (ordersViewModel == null) {
				ordersViewModel = new OrdersViewModel();
			}
		return ordersViewModel;
	}
	
	public List<OrderedItems> getHistory(String mailid){
		List<OrderedItems> orderList = Repository.getInstance().getHistory(mailid);
		return orderList;
	}
	
	public boolean orderItems(String mailid , String rowno , int seatno , String totalAmountPaid) {
		Repository.getInstance().orderItems(mailid, rowno, seatno, totalAmountPaid);
		return true;
	}

	public List<OrderedItemsDetails> getOrderItemDetails(int orderid) {
		List<OrderedItemsDetails> orderList = Repository.getInstance().getOrderItemDetails(orderid);
		return orderList;
	}

	public boolean addReview(String mail_id, int snack_id, String review) {
		Repository.getInstance().addReview(mail_id, snack_id, review);
		return true;
	}

	public List<String> getReviews(int snackid) {
		List<String> reviews = Repository.getInstance().getReviews(snackid);
		return reviews;
	}
}
