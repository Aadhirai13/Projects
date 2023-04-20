package leet;
import java.util.*;

public class LongPalSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "cbbd";
		System.out.println(longestPalindrome(str));
	}
	public static String longestPalindrome(String str) {
		int max = 0,count = str.length();
		while(count>=1) {
	        for(int i=0;i<=str.length()-count;i++){
	        	if(isPalindrome(str.substring(i,count+i)))
	        		return str.substring(i,count+i);
	        }
	        count--;
		}
		return "no palindromic string";
	}
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s); 
		sb.reverse();
		if(s.equals(sb.toString()))
			return true;
		return false;
	}
}
