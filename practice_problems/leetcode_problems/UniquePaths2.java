package leet;

public class UniquePaths2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
			System.out.println(uniquePaths(arr));
		}
		public static int uniquePaths(int[][] arr) {
			if(arr[0][0] == 1)
				return 0;
			arr[0][0] = 1;
			int m = arr.length , n = arr[0].length;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(i==0 && j==0)
						continue;
					if(arr[i][j] == 1) {
						arr[i][j] = 0;
						continue;
					}
					if(i==0)
						arr[i][j] = arr[i][j-1];
					else if(j==0)
						arr[i][j] = arr[i-1][j];
					else
						arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			return arr[m-1][n-1];
	    }

}
