package leet;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
	}

	    public static int reverse(int x) {
	        long n = 0;
	            if(x < 0){
	                while(x <= 0 ^ x == 0){
		            n = n * 10 + (x % 10);  
		            x = x/10;  
		            // if((n >= Integer.MAX_VALUE) && (n <= Integer.MIN_VALUE))
		            //     return 0;
		            }
	            }
	            if(x > 0){
	                while(x > 0){
	                    n = n * 10 + (x % 10);  
	                    x = x/10;  
	                    // if((n >= Integer.MAX_VALUE) && (n <= Integer.MIN_VALUE))
	                    //     return 0;
	                }
	            }
	            if((n >= Integer.MAX_VALUE) && (n <= Integer.MIN_VALUE))
		                return 0;
		      
		        return (int)n;
	    }
	}

