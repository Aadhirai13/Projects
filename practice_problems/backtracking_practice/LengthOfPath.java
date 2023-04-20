package backtracking;

public class LengthOfPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,3,5));
	}
	public static boolean uniquePaths(int m, int n , int k) {
		int[] len = new int[1];
		find(m , n , k , 0 , 0 , len);
		if(len[0] > k)
			return true;
		return false;
    }
	
	public static void find(int m , int n , int length , int i , int j , int[] len) {
		if(i == m-1 && j == n-1) {
			if(len[0] > length) {
				len[0] = length;
			}
			else {
				len[0] = 0;
			}
			return;
		}
		if(i == m || j == n)
			return;
		len[0]++;
		find(m , n , length , i , j+1 , len);
		len[0]++;
		find(m , n , length , i+1 , j , len);
	}


}
