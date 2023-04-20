package hardleet;

public class Dungeon174 {

	public static void main(String[] args) {
		int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(arr));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        dungeon[row-1][col-1] = (dungeon[row-1][col-1] >= 0)?0:dungeon[row-1][col-1];
        
        for(int i = row-2;i >= 0;i--) {
        	int sum = (dungeon[i][col-1] + dungeon[i+1][col-1]);
        	dungeon[i][col-1] = (sum >= 0)?0:sum;
        }
        
        for(int j = col-2;j >= 0;j--) {
        	int sum = (dungeon[row-1][j] + dungeon[row-1][j+1]);
        	dungeon[row-1][j] = (sum >= 0)?0:sum;
        }
        
        for(int i = row-2;i >= 0;i--) {
        	for(int j = col-2;j >= 0;j--) {
        		int max = Math.max(dungeon[i+1][j], dungeon[i][j+1]);
        		int sum = (dungeon[i][j] + max);
            	dungeon[i][j] = (sum >= 0)?0:sum;
        	}
        }
        
        return Math.abs(dungeon[0][0])+1;
    }

}
