package leet;
import java.util.*;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcadcbb";
		System.out.println(findLen(str));
	}
	public static int findLen(String str) {
		int len = str.length(),max = Integer.MIN_VALUE;
		HashSet<Character> h = new HashSet<>();
		String newStr = "";
		if(len == 0)
			return 0;
		else if(len == 1)
			return 1;
		int index = 0;
		for(int i=index;i<len;) {
			if(!(h.contains(str.charAt(i)))){
				h.add(str.charAt(i));
				newStr += str.charAt(i);
				i++;
			}
			else {
				max = Math.max(newStr.length(), max);
				h.clear();
				newStr = "";
				i = index++;
			}
		}
		return max;
	}
}
