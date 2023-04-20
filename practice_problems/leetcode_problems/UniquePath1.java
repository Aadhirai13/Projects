package leet;

import java.util.ArrayList;
import java.util.List;

public class UniquePath1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,3));
	}
	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		arr[0][0] = 1;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0)
					continue;
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
