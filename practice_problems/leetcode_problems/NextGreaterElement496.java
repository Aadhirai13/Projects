package leet;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement496 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = (nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],i);
        }

        outer:
        for(int i=0;i<nums1.length;i++){
            int key = nums1[i];
            Integer value = hm.get(key); //index
            if(value != null){
                for(int j=value+1;j<nums2.length;j++){
	                if(nums2[j] > key) {
	                    ans[i] = nums2[j];
	                    continue outer;
	                }
                }
                ans[i] = -1;
            }
        }

        return ans;
    }

}
