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
import com.zsgs.model.Categories;


@WebServlet("/getcategories")
public class GetCategories extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println(getCategories());
	}
	
	public JSONArray getCategories() {
		List<Categories> categories = HomeViewModel.getInstance().getCategories();

		if (categories.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (Categories category : categories) {

			JSONObject obj = new JSONObject();

			obj.put("categoryname", category.getCategory());
			obj.put("categoryimage", category.getCategoryImage());
			obj.put("categorydesc", category.getCategoryDesc());
			obj.put("categoryid", category.getCategoryId());

			array.add(obj);
		}

		return array;
	}
}