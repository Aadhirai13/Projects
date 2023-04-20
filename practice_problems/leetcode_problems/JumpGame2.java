package leet;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,1};
		System.out.println(jump(arr));
	}
	
	public static int jump(int[] nums) {
        int start = 0 ,index = 0 , end = nums.length - 1 , jump = 0;;
        while(start < end) {
        	jump++;
        	int s = start;
        	int e = nums[start] + start;
        	start = findNext(nums , s , e);
        }
        
        return jump;
    }
	
	public static int findNext(int[] nums , int s , int e) {
		int index = 0 , max = 0;
		if(e > nums.length - 1)
			index = e = nums.length - 1;
		else {
		for(;s <= e && s < nums.length;s++) {
			int n = s + nums[s];
			if(n > max) {
				max = n;
				index = s;
			}
		}
		}
		return index;
	}

}
