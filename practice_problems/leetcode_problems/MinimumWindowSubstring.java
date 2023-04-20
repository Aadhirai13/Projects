package leet;
import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbaa", t = "aba";
		System.out.println(minWindow(s,t));
	}
	public static String minWindow(String s, String t) {
        String substr = "";
        if(t.length() > s.length())
        	return "";
        else if((t.length() == s.length() && (s.equals(t))))
                return s;
        else if(t.length() == 1 && (s.contains(t)))
        	return t;
        	
        int len = Integer.MAX_VALUE,count = 0,index = -1;
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(int i=0;i<t.length();i++) {
        	if (m1.containsKey(t.charAt(i))) 
                m1.put(t.charAt(i), m1.get(t.charAt(i)) + 1);  
            else {
                m1.put(t.charAt(i), 1); 
                m2.put(t.charAt(i), 0); 
            }
        }
        for(int i=0,j=i;j<s.length();j++) {
        	if (m2.containsKey(s.charAt(j))) {
        		count++;
        		if(count == 1)
        			i = j;
                m2.put(s.charAt(j), m2.get(s.charAt(j)) + 1);
                if(count == 2)
                	index = j;
        	}
        	if(!(m2.containsValue(0)) && checkValues(m1,m2,t)) {
        		if((j-i+1) < len) {
        			len = j-i+1;
        			substr = s.substring(i,j+1);
        		}
        		i = index;
    			j = index-1;
    			count = 0;
    			for(int x=0;x<t.length();x++) 
    				m2.put(t.charAt(x), 0); 
        	}
        }
        return substr;
    }

	public static boolean checkValues(Map<Character,Integer> m1,Map<Character,Integer> m2,String t) {
		for(int i=0;i<t.length();i++) {
			if(m2.get(t.charAt(i)) < m1.get(t.charAt(i)))
					return false;
		}
		return true;
	}
}
