package backtracking;

public class PossiblePathsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,7));
	}
	public static int uniquePaths(int m, int n) {
		int[] cnt = new int[1];
		find(m , n , 0 , 0 , cnt);
        return cnt[0];
    }
	
	public static void find(int m , int n , int i , int j , int[] cnt) {
		if(i == m-1 && j == n-1) {
			cnt[0]++;
			return;
		}
		if(i == m || j == n)
			return;
		find(m , n , i , j+1 , cnt);
		find(m , n , i+1 , j , cnt);
	}

}
