package backtracking;

import java.util.*;

public class DistinctSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,3};
		System.out.println(subsetsWithoutDup(arr));
	}

	public static List<List<Integer>> subsetsWithoutDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
		find(0 , nums , new ArrayList<Integer>() , list);
		List<List<Integer>> result = new LinkedList<>(list);
		return result;
    }

    public static void find(int index , int[] nums , List<Integer> ds , Set<List<Integer>> list) {
		if(index == nums.length) {
			list.add(new ArrayList<>(ds));
			return;
		}
		ds.add(nums[index]);
		find(index + 1 , nums , ds , list);
		ds.remove(ds.size() - 1);
		find(index + 1 , nums , ds , list);
	}

}
