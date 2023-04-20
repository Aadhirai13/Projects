package hardleet;

public class SnakeAndLadder909 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(snakesAndLadders(new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
	}
	
	public static int snakesAndLadders(int[][] board) {
		int[] cnt = new int[1];
        helper(board , board.length-1,0,cnt);
        return cnt[0];
    }

	private static void helper(int[][] board, int i, int j, int[] cnt) {
		if(i==0 && j==0)
			return;
		
		
		
		return;
	}

}
