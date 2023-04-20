 package com.zsgs.crm.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CrmRepository {

	public static CrmRepository crmRepository;
	private static Connection con;

	private CrmRepository() {
	}

	public static CrmRepository getInstance() {
		try {
			if (crmRepository == null) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "Aadhisql@1312");
				crmRepository = new CrmRepository();
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getInstance()");
		}
		return crmRepository;
	}

	public boolean validateUserCredentials(String userName, String mobileNumber) {
		boolean isExistingUser = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * from UserCredentials WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			isExistingUser = resultSet.next();

		} catch (SQLException e) {
			System.out.println("sql exception in validateUserCredentials()" + e);
		}
		return isExistingUser;
	}

	public boolean userSignUp(String userName, String mobileNumber) {
		boolean isExistingUser = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM UserCredentials WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			isExistingUser = resultSet.next();

			if (!isExistingUser) {
				String s = "INSERT INTO UserCredentials (userName,mobileNumber) VALUES ( \"" + userName + "\",\""
						+ mobileNumber + "\")";
				stmt.execute(s);
				String s1 = "INSERT INTO Leads (username,mobileNumber) VALUES ( \"" + userName + "\",\"" + mobileNumber + "\")";
				stmt.execute(s1);
			}
		} catch (SQLException e) {
			System.out.println("sql exception in userSignUp()");
		}
		return isExistingUser;
	}

	public boolean isLead(String mobileNumber) {
		boolean isLead = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT isLead FROM UserCredentials WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet.next()) {
				isLead = resultSet.getBoolean("isLead");
			}
		} catch (SQLException e) {
			System.out.println("sql exception in isLead()");
		}
		return isLead;
	}

	public boolean isCallRecieved(String mobileNumber) {
		boolean isCallReceived = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT callRecieved FROM Leads WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet.next()) {
				isCallReceived = resultSet.getBoolean("callRecieved");
			}
		} catch (SQLException e) {
			System.out.println("sql exception in isCallRecieved()");
		}
		return isCallReceived;
	}

	public ArrayList<Integer> getCallDetails(String mobileNumber) {
		ArrayList<Integer> callDetails = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT minimumLoanAmount,monthlyInterestPercent FROM Accounts";

			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet.next()) {
				callDetails.add(resultSet.getInt("minimumLoanAmount"));
				callDetails.add(resultSet.getInt("monthlyInterestPercent"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getCallDetails()");
		}
		return callDetails;
	}

	public void storeContactDetails(String userName, String mobileNumber, String location, String accountNumber,
			int loanAmount, int monthlyInterestPercent, float monthlyInterestAmount) {
		// update in Contacts table
		try {
			Statement stmt = con.createStatement();

			String s = "INSERT INTO Contacts (userName,mobileNumber,location,accountNumber,loanAmount,monthlyInterestPercent,monthlyInterestAmount) VALUES ( \""
					+ userName + "\",\"" + mobileNumber + "\",\"" + location + "\",\"" + accountNumber + "\","
					+ loanAmount + "," + monthlyInterestPercent + "," + monthlyInterestAmount + ")";
			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("sql exception in storeContactDetails()-1");
		}

		// change isLead in UserCredentials
		try {
			Statement stmt = con.createStatement();

			String s = "UPDATE UserCredentials SET isLead = " + false + " WHERE mobileNumber = \"" + mobileNumber
					+ "\"";
			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("sql exception in storeContactDetails()-2");
		}

		// remove lead from Leads table
		try {
			Statement stmt = con.createStatement();

			String s = "DELETE from Leads WHERE mobileNumber = \"" + mobileNumber + "\"";
			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("sql exception storeContactDetails()-3");
		}
	}

	public ArrayList getContactDetails(String mobileNumber) {
		ArrayList contactDetails = new ArrayList();
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Contacts WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet.next()) {
				contactDetails.add(resultSet.getString("userName"));
				contactDetails.add(resultSet.getString("mobileNumber"));
				contactDetails.add(resultSet.getString("location"));
				contactDetails.add(resultSet.getString("accountNumber"));
				contactDetails.add(resultSet.getInt("loanAmount"));
				contactDetails.add(resultSet.getInt("monthlyInterestPercent"));
				contactDetails.add(resultSet.getInt("monthlyInterestAmount"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getContactDetails()");
		}
		return contactDetails;
	}

	public boolean validateAccountsCredentials(String userName, String password) {
		boolean isValid = true;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Accounts";

			ResultSet resultSet = stmt.executeQuery(query);

			if (!resultSet.next()) {
				try {
					Statement stmt1 = con.createStatement();

					String query1 = "INSERT INTO Accounts (userName,password) VALUES ( \"" + userName + "\",\""
							+ password + "\")";

					stmt1.execute(query1);

				} catch (SQLException e) {
					System.out.println("sql exception in validateAccountsCredentials()-1");
				}
			} else {
				try {
					Statement stmt2 = con.createStatement();

					String query2 = "SELECT * FROM Accounts WHERE userName = \"" + userName + "\" AND password = \"" + password + "\"";

					ResultSet resultSet2 = stmt2.executeQuery(query2);

					if (resultSet2.next()) 
						isValid = true;
					else 
						isValid = false;
				} catch (SQLException e) {
					System.out.println("sql exception in validateAccountsCredentials()-2");
				}
			}

		} catch (SQLException e) {
			System.out.println("sql exception in validateAccountsCredentials()-3");
		}
		return isValid;
	}

	public HashMap<String, String> getLeads() {
		HashMap<String, String> leads = new HashMap<>();

		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Leads";

			ResultSet resultSet = stmt.executeQuery(query);

			while(resultSet.next()) {
				leads.put(resultSet.getString("mobileNumber"), resultSet.getString("username"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getLeads()");
		}
		return leads;
	}

	public void callLead(String mobileNumber) {
		try {
			Statement stmt = con.createStatement();

			String query = "UPDATE Leads SET callRecieved = " + true + " WHERE mobileNumber = \"" + mobileNumber + "\"";

			stmt.execute(query);

		} catch (SQLException e) {
			System.out.println("sql exception in callLead()" + e);
		}
	}

	public ArrayList<ArrayList> getContacts() {
		ArrayList<ArrayList> allContactDetails = new ArrayList<>();
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Contacts";

			ResultSet resultSet = stmt.executeQuery(query);

			while(resultSet.next()) {
				ArrayList contactDetails = new ArrayList<>();
				contactDetails.add(resultSet.getString("userName"));
				contactDetails.add(resultSet.getString("mobileNumber"));
				contactDetails.add(resultSet.getString("location"));
				contactDetails.add(resultSet.getString("accountNumber"));
				contactDetails.add(resultSet.getInt("loanAmount"));
				contactDetails.add(resultSet.getInt("monthlyInterestPercent"));
				contactDetails.add(resultSet.getInt("monthlyInterestAmount"));
				contactDetails.add(resultSet.getFloat("individualProfitPercent"));
				allContactDetails.add(contactDetails);
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getContacts()");
		}
		return allContactDetails;
	}

	public void updateContacts() {
		try {
			float totalProfitAmount = 0;
			Statement stmt = con.createStatement();

			String query = "SELECT monthlyInterestAmount FROM Contacts";

			ResultSet resultSet = stmt.executeQuery(query);

			while(resultSet.next()) {
				totalProfitAmount += resultSet.getFloat("monthlyInterestAmount");
			}

			try {
			String query2 = "SELECT monthlyInterestAmount,mobileNumber FROM Contacts";
			ResultSet resultSet1 = stmt.executeQuery(query2);
			while(resultSet1.next()) {
				float individualProfitPercent = (float)(resultSet1.getFloat("monthlyInterestAmount")
						/ totalProfitAmount)*100;
				String mobileNumber = resultSet1.getString("mobileNumber");
				try {
					Statement stmt1 = con.createStatement();

					String query1 = "UPDATE Contacts SET individualProfitPercent = " + individualProfitPercent + " WHERE mobileNumber = \"" + mobileNumber + "\"";
					stmt1.execute(query1);

				} catch (SQLException e) {
					System.out.println("sql exception in updateContacts()-1");
				}
			}
			}catch(Exception e) {
				System.out.println("Sql exception in updateContacts()-2");
			}
		} catch (SQLException e) {
			System.out.println("sql exception in updateContacts()-3");
		}
	}
}
