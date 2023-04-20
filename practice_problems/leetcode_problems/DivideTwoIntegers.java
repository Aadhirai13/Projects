package leet;

public class DivideTwoIntegers {
	
	public static void main(String[] args) {
		System.out.println(divide(7,-3));
	}

	public static int divide(int dividend, int divisor) {
		int cnt = 0;
		int d = (divisor<0) ? Math.negateExact(divisor) : divisor;
		for(int i=0;i<d;i++) {
			dividend -= d;
			cnt++;
			if(dividend < d)
				break;
		}
        return (dividend<0 ^ divisor<0) ? Math.negateExact(cnt) : cnt;
    }
}
