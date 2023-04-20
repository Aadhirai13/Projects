package leet;

import java.util.*;

public class MajorityElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,3};
		majorityElement(arr);
	}
	public static void majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if(nums.length == 1){
            list.add(nums[0]);
            System.out.println(list);
        }
		
		Arrays.sort(nums);
		int j = 0 , n = nums.length/3;

		for(int i = 0;i<nums.length;i++) {
			j = i + n;
			if(j<nums.length && nums[j] == nums[i]) {
				list.add(nums[i]);
                i+=n;
				while(i<nums.length-1 && nums[i] == nums[i+1]) {
					i++;
				}
			}
		}
		
		System.out.println(list);
    }
}



//public static void majorityElement(int[] nums) {
//	List<Integer> list = new ArrayList<>();
//	if(nums.length == 1){
//        list.add(nums[0]);
//        System.out.println(list);
//    }
//	
//	Integer i = nums.length / 3;
//	HashMap<Integer,Integer> h = new HashMap<>();
//	for(int item : nums) {
//		if(h.containsKey(item))
//			h.put(item, (h.get(item) + 1));
//		else
//			h.put(item, 1);
//	}
//	for(Map.Entry<Integer,Integer> entry : h.entrySet())
//		if(entry.getValue() > i)
//			list.add(entry.getKey());
//	System.out.println(list);
//}