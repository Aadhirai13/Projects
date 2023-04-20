//on changing something in java files, we need to restart the server each and everytime

package com.zoho.zsgs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {
	
	public String[] servers = {
			"http://aadhirai-a:8081",
			"http://aadhirai-a:8082",
			"http://aadhirai-a:8083",
			"http://aadhirai-a:8084"};

	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException , ServletException{
//		String name = req.getParameter("myName"); //parameter should be same as name attribute's value of input
//		String welcomeMessage = "Welcome to our page Mr/Ms. " + name;
		
		String ipAddress = req.getRemoteAddr();
		int port = req.getLocalPort();
		
		System.out.println("IP Address : " + ipAddress + " Port no - " + port);
		
		String serverUrl = balanceLoad(ipAddress);
		
		if(port != Integer.parseInt(serverUrl.split(":")[2])) {
			System.out.println("Redirecting url : " + serverUrl);
			res.sendRedirect(serverUrl); // redirecting to serverUrl
		}
		
		PrintWriter pw = res.getWriter();
		pw.print("Welcome " + serverUrl);
	}
	
	private String balanceLoad(String ipAddress) {
		
		// ipv4 has 4 parts -> 127.127.127.127 where as ipv6 has 6 parts -> 12:12:12:12:12:12 , jio has 8 parts
		String lastPart = ipAddress.contains(":") ? ipAddress.split(":")[5] : ipAddress.split("\\.")[3];
		int lastPartOfIpAddress = Integer.parseInt(lastPart);
		
		int portOption = (lastPartOfIpAddress % 4);
		
		return servers[portOption];
	}
}
