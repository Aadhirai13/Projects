package leet;
import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		ArrayList<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s,wordDict));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		int i = 0;
		String str = s;
		while(i < str.length()) {
			if(!(wordDict.contains(str.substring(i)))){
				i++;
			}
			else {
				str = s.substring(0,i);
				i = 0;
			}
		}
		if(str.length() == 0)
			return true;
		return false;
    }

}
