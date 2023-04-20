package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.zsgs.model.OrderedItemsDetails;
import com.zsgs.orders.OrdersViewModel;

@WebServlet("/viewOrderDetails")
public class ViewOrderDetails extends HttpServlet {

	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int orderid = Integer.parseInt(req.getParameter("orderid"));
		
		List<OrderedItemsDetails> orderedItemDetails = OrdersViewModel.getInstance().getOrderItemDetails(orderid);

		JSONArray array = new JSONArray();

		for (OrderedItemsDetails items : orderedItemDetails) {

			JSONObject obj = new JSONObject();

			obj.put("order_id", items.getOrder_id());
			obj.put("mail_id", items.getMail_id());
			obj.put("category_id", items.getCategory_id());
			obj.put("snack_id", items.getSnack_id());
			obj.put("snack_name", items.getSnack_name());
			obj.put("snack_count", items.getSnack_count());
			obj.put("snack_amount", items.getSnack_amount());

			array.add(obj);
		}
		
		out.println(array);
	}

}


