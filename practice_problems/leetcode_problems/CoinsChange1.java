package leet;

public class CoinsChange1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		System.out.println(coinChange(arr , 3));
	}
	
	public static int coinChange(int[] coins, int amount) {
		int count = 0;
		int[][] dp = new int[coins.length][amount+1];
		count = helper(coins.length-1 , coins , amount , dp , count);
//		for(int[] arr: dp)
//			for(int n : arr)
//				System.out.print(n);
		return count;
	}
	
	public static int helper(int index , int[] coins , int target , int[][] dp , int count) {
		if(index < 0 || target < 0) 
			return Integer.MAX_VALUE;
		if(target == 0 || count != 0) {
			dp[index][target] = count;
		}		
		helper(index-1 , coins , target , dp , count);
		helper(index , coins , target - coins[index] , dp , count+1);
		return dp[0][0];
	}
	
}
