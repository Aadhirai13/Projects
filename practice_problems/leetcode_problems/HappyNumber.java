package leet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(5));
	}
	public static boolean isHappy(int n) {		
		if(n==1 || n==10)
        	return true;
        while(n>4) {
        	int rem,sum = 0;
	        while(n>0) {
	        	rem = n%10;
	        	sum += Math.pow(rem, 2);
	        	n=n/10;
	     	}
	        n = sum;
	        System.out.println(n);
	        if(n==1 || n==10)
            	return true;
        }
        return false;
    }

}
