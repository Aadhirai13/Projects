package leet;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("+12"));
	}
	    public static int myAtoi(String s) {
	    	char arr[] = s.trim().toCharArray();
	    	int i = 0;
	    	s = "";
	    	if(arr.length == 0 || !(arr[i] == '+' || arr[i] == '-' || Character.isDigit(arr[i]))                || (arr.length == 1 && !(Character.isDigit(arr[0]))))
	    		return 0;
	    	if(arr[0] == '-') {
	    		s += arr[0];
	    		i++;
	    	}
            else if(arr[i] == '+') 
	    		i++;
	    	while(i < arr.length && Character.isDigit(arr[i])) {
	    		s += arr[i];
	    		i++;
                if(Long.parseLong(s) >= Integer.MAX_VALUE) 
	                return Integer.MAX_VALUE;
	            if(Long.parseLong(s) <= Integer.MIN_VALUE)
	                return Integer.MIN_VALUE;
	    	}
	    	if(i == 1 && !(Character.isDigit(arr[0])))
	    		return 0;
	    	return Integer.parseInt(s);
}
}
