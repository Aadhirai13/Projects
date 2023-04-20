package leet;

public class NumberOfArithmeticSlices {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[]nums = {1,2,3,4,5,6};
			System.out.println(numberOfArithmeticSlices(nums));
	}
	public static int numberOfArithmeticSlices(int[] nums) {
		if(nums.length < 3)
            return 0;
		if(nums.length == 3){
            if(nums[2]-nums[1] == nums[1]-nums[0])
                return 1;
            else
                return 0;
        }
        for(int i=0;i<nums.length-2;i++) {
        	checkSlice(nums,i,i+2);
        }
        return count;
    }
	
	public static void checkSlice(int arr[],int s,int e) {
		if((arr[e]-arr[s]) % (arr[e]-arr[e-1]) ==0) {
    		count++;
    		if((e+1) < arr.length)
    			checkSlice(arr,s,e+1);
		}
	}
}
