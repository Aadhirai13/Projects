package leet;

import java.util.*;

public class GenerateParenthesis22 {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(4).size());
	}
	
	public static List<String> generateParenthesis(int n) {
		
        List<String> list = new ArrayList<>();
        if(n == 0)
			return list;
        if(n == 1) {
        	list.add("()");
        	return list;
        }
        helper(n,"(",1,0,list);
        return list;
    }

	private static void helper(int n, String str, int open, int close, List<String> list) {
		if(str.length() == (n*2)) {
			list.add(str);
			return;
		}
		
		if(open < n) {
			helper(n,str+"(",open+1,close,list);
		}
		if(close < open)
			helper(n,str+")",open,close+1,list);
	}

}
