package leet;
import java.util.*;

public class Subset2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1};
		Arrays.sort(arr);
		System.out.println(subsetsWithDup(arr));
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();
		find(0 , nums , new ArrayList<Integer>() , list);
		List<List<Integer>> result = new ArrayList<>(list);
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
