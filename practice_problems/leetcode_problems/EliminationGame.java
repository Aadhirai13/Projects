package leet;

public class EliminationGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(15));
	}
	public static int lastRemaining(int n) {
		if(n<=2)
			return n;
		int a = n,cnt = 0;
        while(a!=1) {
        	a/=2;
        	cnt++;
        }
        if(cnt % 2 != 0)
        	return n-cnt;
        else
        	return cnt;
    }

}
