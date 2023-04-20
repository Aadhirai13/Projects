package leet;
import java.util.*;

public class FrequencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frequencySort("abee");
	}
	
	public static void frequencySort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = "";
        for(char ch : arr)
            s += ch;
        find(s);
    }
	
	public static void find(String s) {
        StringBuilder str1 = new StringBuilder();
        int j = 0 , max = 0,cnt = 0;
        String str = "";
        
        for(int i = 0;i<s.length()-1;i++) {
        	cnt = 0;
        	while(j < s.length()) {
        		if(s.charAt(i) == s.charAt(j)) {
        			j++;
        			cnt++;
        		}
        		else if(cnt >= max) {
        			str = s.substring(i,j);
        			System.out.println(str);
        			max = cnt;
        			break;
        		}
        	}
        }
        System.out.println(s);
    }

}
