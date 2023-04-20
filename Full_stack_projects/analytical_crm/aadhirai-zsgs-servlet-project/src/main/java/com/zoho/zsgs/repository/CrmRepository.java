package com.zoho.zsgs.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zoho.zsgs.model.ContactDetails;
import com.zoho.zsgs.model.Dashboard;
import com.zoho.zsgs.model.LeadsDetails;

public class CrmRepository {

	public static CrmRepository crmRepository;
	private static Connection con;
	private List<LeadsDetails> leadDetails = new ArrayList();
	private static String mobile = "";
	private static String user = "";
	
	
	private List<ContactDetails> contactDetails = new ArrayList<>();
	private List<Dashboard> dashboardDetails = new ArrayList<>();

	private CrmRepository() {
	}

	public static CrmRepository getInstance() {
		try {
			if (crmRepository == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "Aadhisql@1312");
				crmRepository = new CrmRepository();
			}
		} catch (SQLException e) {
			System.out.println("sql exception in getInstance()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return crmRepository;
	}

	public boolean validateUserCredentials(String userName, String mobileNum) {
		boolean isExistingUser = false;
		setNumber(mobileNum);
		setUsername(userName);
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * from UserCredentials WHERE mobileNumber = \"" + mobileNum + "\"";

			ResultSet resultSet = stmt.executeQuery(query);

			isExistingUser = resultSet.next();
			
			

		} catch (SQLException e) {
			System.out.println("sql exception in validateUserCredentials()" + e);
		}
		return isExistingUser;
	}

	private void setNumber(String mobileNum) {
		mobile = mobileNum;
	}
	
	public String getNumber() {
		return CrmRepository.mobile;
	} 
	
	private void setUsername(String username) {
		user = username;
	}
	
	public String getUsername() {
		return CrmRepository.user;
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

	public boolean isLead(String mobileNum) {
		boolean isLead = false;
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT isLead FROM UserCredentials WHERE mobileNumber = \"" + mobileNum + "\"";

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

	public List<ContactDetails> getContactDetails(String mobileNumber) {
		
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Contacts WHERE mobileNumber = \"" + mobileNumber + "\"";

			ResultSet resultSet = stmt.executeQuery(query);
			contactDetails.clear();
			
			while(resultSet.next()) {
				contactDetails.add(new ContactDetails(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public List<LeadsDetails> getLeads() {

		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String SELECT_STATEMENT = "SELECT * FROM Leads";
		try {
			ResultSet set = stmt.executeQuery(SELECT_STATEMENT);
			leadDetails.clear();
			while(set.next()) {
				leadDetails.add(new LeadsDetails(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getLeads()");
		}
		return leadDetails;
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

	public List<ContactDetails> getContacts() {
		
		try {
			Statement stmt = con.createStatement();

			String query = "SELECT * FROM Contacts";

			ResultSet resultSet = stmt.executeQuery(query);
			
			contactDetails.clear();
			
			while(resultSet.next()) {
				contactDetails.add(new ContactDetails(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql exception in getContacts()");
		}
		
		return contactDetails;
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

//	public List<Dashboard> getDashboardDetails() {
//		try {
//			Statement stmt = con.createStatement();
//
//			String query = "SELECT userName,individualProfitPercent FROM Contacts";
//
//			ResultSet resultSet = stmt.executeQuery(query);
//			
//			dashboardDetails.clear();
//			
//			while(resultSet.next()) {
//				dashboardDetails.add(new Dashboard(resultSet));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("sql exception in getDashboardDetails()");
//		}
//		
//		return dashboardDetails;
//	}
}
