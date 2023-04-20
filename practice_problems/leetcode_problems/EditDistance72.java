package hardleet;

public class EditDistance72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("horse","ros"));
	}
	
	public static int minDistance(String word1, String word2) {
		int n = word1.length(), m = word2.length();
        int[][] dp = new int[n][m];
        return helper(n-1,m-1,word1,word2,dp);
    }

	private static int helper(int i, int j, String word1, String word2, int[][] dp) {
		if(i == -1)
			return j+1;
		if(j == -1)
			return i+1;
		if(dp[i][j] != 0)
			return dp[i][j];
		
		if(word1.charAt(i) == word2.charAt(j))
			return dp[i][j] = helper(i-1,j-1,word1,word2,dp);
		else {
			return dp[i][j] = 1 + Math.min(helper(i,j-1,word1,word2,dp), 
					Math.min(helper(i-1,j-1,word1,word2,dp), helper(i-1,j,word1,word2,dp)));
		}
	}

}
