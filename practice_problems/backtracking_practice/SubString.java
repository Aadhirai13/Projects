package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aadhirai";
		String substr = "adh";
		System.out.println(isSubstring(str , substr));
	}

	public static boolean isSubstring(String str , String substr) {	
		for(int i = 0 ; i < str.length()-substr.length() ; i++)
			if(find(i , str , substr , new ArrayList<Character>()))
				return true;
		return false;
    }

    public static boolean find(int index , String str , String substr , List<Character> ds) {
    	if((ds.size() == substr.length())) {
			StringBuilder sb = new StringBuilder();
	        for (Character ch : ds) {
	            sb.append(ch);
	        }
			if(substr.equals(sb.toString()))
				return true;
			return false;
		}
		ds.add(str.charAt(index));
		return find(index + 1 , str , substr , ds);
	}

}
