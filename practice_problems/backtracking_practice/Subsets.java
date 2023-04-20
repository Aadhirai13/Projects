package backtracking;
import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		System.out.println(subsetsWithDup(arr));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
		find(0 , nums , new ArrayList<Integer>() , list);
		return list;
    }

    public static void find(int index , int[] nums , List<Integer> ds , List<List<Integer>> list) {
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
