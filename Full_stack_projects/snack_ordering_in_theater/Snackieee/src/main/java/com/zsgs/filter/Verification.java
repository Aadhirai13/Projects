package com.zsgs.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
	
	public static boolean validateMail(String mail) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9_$]+[@][a-z]+[.][a-z]{2,3}");
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}

	public static boolean name(String name) {
		String rejex = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(rejex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public static boolean pass(String pass) {

		if (pass.length() < 8) {
			return false;
		}

		String rejex = "[A-Z]+";
		Pattern pattern = Pattern.compile(rejex);
		Matcher matcher = pattern.matcher(pass);

		if (!matcher.find()) {
			return false;
		}

		rejex = "[a-z]+";

		pattern = Pattern.compile(rejex);
		matcher = pattern.matcher(pass);

		if (!matcher.find()) {
			return false;
		}

		rejex = "[0-9]+";

		pattern = Pattern.compile(rejex);
		matcher = pattern.matcher(pass);

		if (!matcher.find()) {
			return false;
		}

//		rejex = "[a-zA-Z0-9]*[@#$!%^&*][a-zA-Z0-9]*[@#$!%^&*][a-zA-Z0-9]*"; for two special charactor
		rejex = "[!@#$%^&*()_+-/.]+";

		pattern = Pattern.compile(rejex);
		matcher = pattern.matcher(pass);

		if (!matcher.find()) {
			return false;
		}

		return true;
	}
}