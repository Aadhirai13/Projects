package leet;
import java.util.*;

public class LongSubstrRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcadcbb";
		System.out.println(lengthOfLongestSubstring(str));
	}
	    public static int lengthOfLongestSubstring(String s) {
	        int i=0;
	        int j=0;
	        HashSet<Character> hash=new HashSet<Character>();
	        int maxLen=0;
	        while(j<s.length()){
	          
	            if(hash.contains(s.charAt(j))){
	                while(s.charAt(i)!=s.charAt(j)){
	                    hash.remove(s.charAt(i));
	                    i++;
	                }
	                i++;
	            }
	            else{
	                hash.add(s.charAt(j));
	            }
	            maxLen=Math.max(maxLen,j-i+1);
	            j++;
	        }
	        return maxLen;
	    }
}

	
