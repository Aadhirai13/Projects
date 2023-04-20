package leet;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {23,2,6,4,7};
		System.out.println(checkSubarraySum(arr,13));

	}
	public static boolean checkSubarraySum(int[] nums, int k) {

        boolean bool = false;
        for(int i = 0 ; i < nums.length ; i++){
            bool = find(i , nums , k , 0);
            if(bool)
                break;
        }
            
        return bool;
    }

    public static boolean find(int index , int[] nums , int target , int sum){
        if(sum != 0 && sum % target == 0){
            return true;
        }
        if(index == nums.length && sum != target)
            return false;

        return find(index + 1 , nums , target , sum + nums[index]);
    }

}
