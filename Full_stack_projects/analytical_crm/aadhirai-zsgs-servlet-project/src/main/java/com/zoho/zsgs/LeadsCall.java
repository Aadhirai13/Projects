package com.zoho.zsgs;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zoho.zsgs.accounts.AccountsViewModel;


@WebServlet("/leadcall")
public class LeadsCall extends HttpServlet{

	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String mobileNumber = req.getParameter("call");
		AccountsViewModel.getInstance().callLead(mobileNumber);
		res.sendRedirect("accountspage.jsp");
	}

}
