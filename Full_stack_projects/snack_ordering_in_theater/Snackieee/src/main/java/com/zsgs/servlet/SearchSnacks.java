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

import com.zsgs.home.HomeViewModel;
import com.zsgs.model.SnackDetails;

@WebServlet("/searchsnack")
public class SearchSnacks extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String searchkeyword = req.getParameter("searchkeyword");
		out.println(getSnacks(searchkeyword));
	}
	
	public JSONArray getSnacks(String searchkeyword) {
		List<SnackDetails> snacks = HomeViewModel.getInstance().getSearchSnacks(searchkeyword);

		if (snacks.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (SnackDetails snack : snacks) {

			JSONObject obj = new JSONObject();
			
			obj.put("snackid", snack.getSnackId());
			obj.put("snackname", snack.getSnackName());
			obj.put("snackprice", snack.getPrice());
			obj.put("snackstock", snack.getStock());
			obj.put("snackquantity", snack.getQuantity());
			obj.put("snackimage", snack.getSnackImage());

			array.add(obj);
		}

		return array;
	}
}
