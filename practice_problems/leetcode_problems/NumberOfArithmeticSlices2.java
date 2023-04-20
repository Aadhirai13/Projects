package leet;

public class NumberOfArithmeticSlices2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(nums));
	}
	public static int numberOfArithmeticSlices(int[] nums) {
		int count = 0;
        if(nums.length < 3)
            return 0;
        int c = 2;
        for(int i=0;i<nums.length-c;i++) {
        	if(((nums[i+c]-nums[i])%c == 0)) {
        	if((nums[i+c]-nums[i])/c == (nums[i+c]-nums[i+c-1])) {
        		count++;
        		if((i+c) == nums.length-1) {
        			i=-1;
        			c++;
        			continue ;
        		}
        	}
        	}
        }
        return count;
    }

}
