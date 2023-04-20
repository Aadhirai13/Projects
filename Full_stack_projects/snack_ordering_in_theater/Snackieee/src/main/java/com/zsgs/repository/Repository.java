package com.zsgs.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.zsgs.model.CartItems;
import com.zsgs.model.Categories;
import com.zsgs.model.OrderedItems;
import com.zsgs.model.OrderedItemsDetails;
import com.zsgs.model.SnackDetails;

public class Repository {
	public static Repository repository;
	private static Connection con;

	private List<Categories> catDetails = new ArrayList<>();
	private List<CartItems> cartDetails = new ArrayList<>();
	private List<SnackDetails> snackDetails = new ArrayList<>();
	private List<OrderedItems> history = new ArrayList<>();
	private List<OrderedItemsDetails> orderItemDetails = new ArrayList<>();
	private List<String> reviews = new ArrayList<>();
	
	SnackDetails snack = null;
	
	private Repository() {}

	public static Repository getInstance() {
		try {
			if (repository == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snackiee", "root", "Aadhisql@1312");
				repository = new Repository();
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getInstance()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return repository;
	}

	public List<Categories> getCategories() {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM category_details";

			ResultSet resultSet = stmt.executeQuery(query);
			catDetails.clear();
			
			while(resultSet.next()) {
				catDetails.add(new Categories(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getCategories()");
		}
		return catDetails;
	}
	
	public List<SnackDetails> getSnackItems(int categoryId){
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM snack_details where category_id = \"" + categoryId + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			snackDetails.clear();
			
			while(resultSet.next()) {
				snackDetails.add(new SnackDetails(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getSnackItems()");
		}
		return snackDetails;
	}

	public List<CartItems> getCartItems(String mailId) {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM cart_details where mail_id = \"" + mailId + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			cartDetails.clear();
			
			while(resultSet.next()) {
				cartDetails.add(new CartItems(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getCartItems()");
		}
		return cartDetails;
	}

	public SnackDetails getSnackDetail(int snackId) {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM snack_details where snack_id = \"" + snackId + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			
			if(resultSet.next()) {
				snack = new SnackDetails(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getSnackDetail()");
		}
		return snack;
	}
	
	public List<OrderedItems> getHistory(String mailid) {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM order_specific_details where mail_id = \"" + mailid + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			history.clear();
			
			while(resultSet.next()) {
				history.add(new OrderedItems(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getHistory()");
		}
		return history;
	}

	public boolean addItemsToCart(String mailid ,int snackid, int itemCount) {
		SnackDetails snackdetail = null;
		try {
			
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM snack_details where snack_id = \"" + snackid + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			
			if(resultSet.next()) {
				snackdetail = new SnackDetails(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getHistory()");
		}
		
		if((itemCount < 1) || snackdetail.getStock() < itemCount)
			return false;
		else {
			int olditemcount = 0;
			boolean ispresent = false;
			try {
				try {
					
					Statement stmt2 = con.createStatement();

					String query2 = "SELECT * FROM cart_details where snack_id = \"" + snackid + "\" AND mail_id = \"" + mailid + "\"";

					ResultSet resultSet1 = stmt2.executeQuery(query2);
					
					if(resultSet1.next()) {
						ispresent = true;
						olditemcount = resultSet1.getInt("item_count");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("sql exception in getHistory()");
				}
				
				Statement stmt1 = con.createStatement();
				String query1 = "";
				
				if(!ispresent) {
				float amount = itemCount*snackdetail.getPrice();
				float tax_amount = (float)0.05*amount;
				query1 = "INSERT INTO cart_details (mail_id,category_id,snack_id,snack_name,snack_count,snack_amount,item_count,total_price,tax_amnt) values ( \"" + mailid + "\"," + snackdetail.getCategoryId() + "," + snackdetail.getSnackId() + ",\"" + snackdetail.getSnackName()+ "\"," + snackdetail.getStock()+ "," + snackdetail.getPrice() +  "," + itemCount + "," + amount + "," + tax_amount + ")";

				stmt1.execute(query1);
				}
				else {
					if(snackdetail.getStock() < (itemCount + olditemcount))
						return false;
					float amount = (itemCount + olditemcount)*snackdetail.getPrice();
					float tax_amount = (float)0.05*amount;
					query1 = "UPDATE cart_details SET item_count = ? , total_price = ? , tax_amnt = ? WHERE mail_id = ? AND snack_id = ? ";
					PreparedStatement pst = con.prepareStatement(query1);
					
					pst.setInt(1, (itemCount + olditemcount));
					pst.setFloat(2, amount);
					pst.setFloat(3, tax_amount);
					pst.setString(4, mailid);
					pst.setInt(5, snackid);

					pst.execute();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("sql exception in getHistory()");
			}
		}
		return true;
	}
	
	public void removeFromCart(String mailid , int snackid) {
		try {
			Statement stmt = con.createStatement();

			String query = "DELETE FROM cart_details WHERE mail_id = \"" + mailid + "\" AND snack_id = \"" + snackid + "\""  ;

			stmt.execute(query);
		}
		catch (SQLException e) {
			System.out.println("sql exception in removeFromCart()");
		}
	}
	
	public void orderItems(String mailid , String rowno , int seatno, String amountpaid) {
		try {
			int orderid = 0;
			Statement stmt = con.createStatement();
			
			String q = "SELECT * FROM order_specific_details ORDER BY order_id DESC LIMIT 1";

			ResultSet set = stmt.executeQuery(q);
			if(set.next())
				orderid = set.getInt("order_id") + 1;
			else
				orderid = 1;

			String query1 = "INSERT INTO order_specific_details (mail_id,row_no,seat_no,amount_paid,order_id) VALUES ( \"" + mailid + "\",\""
					+ rowno + "\",\"" + seatno + "\",\"" + amountpaid + "\",\"" + orderid + "\")";

			stmt.execute(query1);
			
			List<CartItems> cartList = getCartItems(mailid);
			
			for(int i=0;i<cartList.size();i++) {
				String insertorderquery = "INSERT INTO order_details (order_id,mail_id,category_id,snack_id,snack_name,snack_count,snack_amount) VALUES ("
						+ "\"" + orderid + "\",\"" + mailid + "\",\"" + cartList.get(i).getCategory_id() + "\",\"" + cartList.get(i).getSnack_id() + "\",\"" + cartList.get(i).getSnack_name() + "\",\"" + cartList.get(i).getItem_count() + "\",\"" + cartList.get(i).getTotal_price() + "\")";
				stmt.execute(insertorderquery);
			}
			
			for(int i=0;i<cartList.size();i++) {
				String getsnackstock = "SELECT * FROM snack_details WHERE snack_id = \"" + cartList.get(i).getSnack_id() + "\" AND category_id = \"" + cartList.get(i).getCategory_id() + "\"";
				ResultSet resultSet = stmt.executeQuery(getsnackstock);
				
				int updatingStock = 0;
				if(resultSet.next())
					updatingStock = resultSet.getInt("stock") - cartList.get(i).getItem_count();
				
				String updatestockquery = "UPDATE snack_details SET stock = \"" + updatingStock + "\" WHERE snack_id = \"" + cartList.get(i).getSnack_id() + "\" AND category_id = \"" + cartList.get(i).getCategory_id() + "\"";
				stmt.execute(updatestockquery);
			}
			
			String query3 = "DELETE FROM cart_details WHERE mail_id = \"" + mailid + "\"";
			stmt.execute(query3);
		
		} catch (SQLException e) {
			System.out.println("sql exception in orderItems()");
		}
	}
	
	public boolean addUser(String username, String email, String password) {
		boolean isExistingUser = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM UserCredentials WHERE email = \"" + email + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			isExistingUser = resultSet.next();

			if (!isExistingUser) {
				String s = "INSERT INTO UserCredentials (username,email,password) VALUES ( \"" + username + "\",\""
						+ email + "\",\"" + password + "\")";
				stmt.execute(s);
			}
		} catch (SQLException e) {
			System.out.println("sql exception in addUser()");
		}
		return isExistingUser;
	}
	
	public boolean validateUserCredentials(String email, String password) {
		boolean isExistingUser = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * from UserCredentials WHERE email = \"" + email +  "\" AND password = \"" + password + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			isExistingUser = resultSet.next();

		} catch (SQLException e) {
			System.out.println("sql exception in validateUserCredentials()" + e);
		}
		return isExistingUser;
	}

	public List<SnackDetails> getSearchSnackItems(String searchkeyword) {
		try {
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM snack_details WHERE snack_name LIKE ? ";
			PreparedStatement pst = null;

			pst = con.prepareStatement(query);
			pst.setString(1, "%" + searchkeyword + "%");
			ResultSet resultSet = pst.executeQuery();
			snackDetails.clear();
			
			while(resultSet.next()) {
				snackDetails.add(new SnackDetails(resultSet));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getSnackItems()");
		}
		return snackDetails;
	}

	public List<OrderedItemsDetails> getOrderItemDetails(int orderid) {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM order_details where order_id = \"" + orderid + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			orderItemDetails.clear();
			
			while(resultSet.next()) {
				orderItemDetails.add(new OrderedItemsDetails(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getCartItems()");
		}
		return orderItemDetails;
	}

	public void addSnacks(int category_id, String snack_name, float price, int stock, String quantity,
			String snack_image) {
		
		try {
			Statement stmt = con.createStatement();
			String query1 = "INSERT INTO snack_details (category_id,snack_name,price,stock,quantity,snack_image) VALUES ( \"" + category_id + "\",\""
					+ snack_name + "\",\"" + price + "\",\"" + stock + "\",\"" + quantity + "\",\"" + snack_image + "\")";

			stmt.execute(query1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception in addSnacks()");
		}
		
	}

	public void addReview(String mail_id, int snack_id, String review) {
		try {
			Statement stmt = con.createStatement();
			String query1 = "INSERT INTO snack_reviews (snack_id,mail_id,review) VALUES ( \"" + snack_id + "\",\""
					+ mail_id + "\",\"" + review + "\")";

			stmt.execute(query1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception in addSnacks()");
		}
	}

	public List<String> getReviews(int snackid) {
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM snack_reviews where snack_id = \"" + snackid + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			reviews.clear();
			
			while(resultSet.next()) {
				reviews.add(resultSet.getString("review"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getReviews()");
		}
		return reviews;
	}
	
}
