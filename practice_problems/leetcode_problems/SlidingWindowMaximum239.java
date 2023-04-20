package hardleet;

import java.util.Arrays;

public class SlidingWindowMaximum239 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSlidingWindow(new int[]{-5769,-7887,-5709,4600,-7919,9807,1303,
				-2644,1144,-6410,-7159,-2041,9059,-663,4612,-257,2870,-6646,8161,
				3380,6823,1871,-4030,-1758,4834,-5317,6218,-4105,6869,8595,8718,-4141,
				-3893,-4259,-3440,-5426,9766,-5396,-7824,-3941,4600,-1485,-1486,-4530,
				-1636,-2088,-5295,-5383,5786,-9489,3180,-4575,-7043,-2153,1123,1750,
				-1347,-4299,-4401,-7772,5872,6144,-4953,-9934,8507,951,-8828,-5942,
				-3499,-174,7629,5877,3338,8899,4223,-8068,3775,7954,8740,4567,6280,
				-7687,-4811,-8094,2209,-4476,-8328,2385,-2156,7028,-3864,7272,-1199,
				-1397,1581,-9635,9087,-6262,-3061,-6083,-2825,-8574,5534,4006,-2691,
				6699,7558,-453,3492,3416,2218,7537,8854,-3321,-5489,-945,1302,-7176,
				-9201,-9588,-140,1369,3322,-7320,-8426,-8446,-2475,8243,-3324,8993,
				8315,2863,-7580,-7949,4400},6));
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(k == 1){
            return nums;
        }
		if(nums.length == k) {
			int arr[] = new int[1];
			Arrays.sort(nums);
        	arr[0] = nums[k-1];
        	return arr;
		}
        int[] arr = new int[nums.length-k+1];
        int index = 0;
        outer:
        for(int i=0;i<=nums.length-k;) {
        	int[] max = new int[2]; // [0] - max value's index & [1] - max value
        	findMax(nums,i,k,max);
        	arr[index++] = max[1];
        	i++;
        	while(i<=nums.length-k && i <= max[0] && nums[i+k-1] <= max[1]) {
        		arr[index++] = max[1];
        		i++;
        	}
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

	private static void findMax(int[] nums, int i, int k, int[] max) {
		int m = nums[i];
		for(int x=i;x<(i+k);x++) {
			if(nums[x] > m) {
				m = nums[x];
				max[0] = x;
			}
		}
		max[1] = m;
	}

	private static int[] copyArray(int[] nums, int i, int j) {
		int[] arr = new int[j];
		int x = 0;
		int y = i;
		for(int a=0;a<j;a++)
			arr[x++] = nums[y++];
		return arr;
	}
}
