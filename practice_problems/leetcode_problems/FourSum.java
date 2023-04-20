package leet;
import java.lang.module.FindException;
import java.util.*;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,0,-1,0,-2,2};
		System.out.println(findSum(arr , 0));
	}

	public static List<List<Integer>> findSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0 , candidates , target , new ArrayList<Integer>() , list);
        return list;
    }

    public static void findCombination(int index , int[] candidates , int target , ArrayList<Integer> ds ,  List<List<Integer>> list){
        if(target < 0)
            return;
        if(ds.size() == 4 && target == 0){
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index ; i < candidates.length ; i++){
            ds.add(candidates[i]);
            findCombination(i+1 , candidates , target - candidates[i] , ds , list);
            ds.remove(ds.size() - 1);
        }

    }
}
