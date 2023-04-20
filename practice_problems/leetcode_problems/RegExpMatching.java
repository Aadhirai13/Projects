package leet;

public class RegExpMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa", "a*"));
	}
	public static boolean isMatch(String s, String p) {
        boolean isMatched = false;
        int j=0;
        for(int i = 0;i<p.length();) {
        	for(;j<s.length();) {
        		if(!(p.charAt(i) == '*')) {
        			if((p.charAt(i) == s.charAt(j)) || (p.charAt(i) == '.')) {
        				i++;
        				j++;
        			}
        			else
        				return false;
        		}
        		else {
        			while(j<s.length() && (s.charAt(j-1) == s.charAt(j))) {
        				j++;
        			}
        		}
        	}
        	if(j == s.length()) {
        		isMatched = true;
        		break;
        	}
        }
        
        return isMatched;
    }
}
