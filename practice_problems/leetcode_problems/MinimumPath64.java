package leet;

public class MinimumPath64 {

	public static void main(String[] args) {
		int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(arr));
	}
	
	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		
		for(int i=row-2;i >= 0;i--) {
			grid[i][col-1] += grid[i+1][col-1];
		}
		
		for(int j=col-2;j >= 0;j--) {
			grid[row-1][j] +=  grid[row-1][j+1];
		}
		
		for(int i = row-2;i >= 0;i--) {
			for(int j = col-2;j >= 0;j--) {
				int min = Math.min(grid[i+1][j], grid[i][j+1]);
				grid[i][j] += min;
			}
		}
		
        return grid[0][0];
    }
}
