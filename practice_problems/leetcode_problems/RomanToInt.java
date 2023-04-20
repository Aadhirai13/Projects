package leet;
import java.util.*;

public class RomanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("LVIII"));

	}
	 public static int romanToInt(String s) {
	        int numbers[] = {1,5,10,50,100,500,1000};
	        String roman[] = {"I","V","X","L","C","D","M"};
	        List<String> rom = Arrays.asList(roman);
	        int result = 0, i;
	
	        for(i = 1 ; i < s.length() ; ) {
	        	if(numbers[rom.indexOf(s.substring(i-1,i))] >= numbers[rom.indexOf(s.substring(i,i+1))]) {
	        		result += numbers[rom.indexOf(s.substring(i-1,i))];
	        		i++;
	        	}
	        	else {
	        		result += numbers[rom.indexOf(s.substring(i,i+1))] - numbers[rom.indexOf(s.substring(i-1,i))];
	        		i = i+2;
	        	}
	        }
	        if(i == s.length())
	        	result += numbers[rom.indexOf(s.substring(i-1))];
	        return result;
	    }

	}



