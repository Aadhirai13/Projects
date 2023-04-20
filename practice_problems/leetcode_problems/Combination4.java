package leet;

public class Combination4 {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,4};
		System.out.println(combinationSum4(arr , 8));
	}
	
	public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] =  1;
        for (int i = 1; i <= target; i++) {
            for (int x: nums) {
                if(i>=x){
                    dp[i] += dp[i-x];
                }
            }
        }
    return dp[target];
    }

}
