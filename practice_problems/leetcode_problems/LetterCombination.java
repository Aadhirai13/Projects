package leet;
import java.util.*;

public class LetterCombination {
	
	static String[] str = {"","","abc","def","jhi","jkl","mno","pqrs","tuv","wxyz"};
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		
		String s = "23";
		int index = 0;
		find(s, index , "");
		System.out.println(list);
	}

	public static void find( String input , int index , String res) {
		if(input.length() == index) {
			list.add(res);
			return;
		}
		String letter = str[input.charAt(index) - '0'];
		for(int i=0;i<letter.length();i++) {
			find(input , index+1 , res + letter.charAt(i));
		}
			
	}
}
