package leet;
import java.util.*;
import java.util.stream.Collectors;


public class Permutation {
	
	static int count = 1;
	static boolean dup = true;
	static List<List<Integer>> res = new ArrayList<>();
	static List<List<Integer>> newList = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = new Integer[]{1,2,3};
		for(int i=0;i<arr.length;i++)
			findPerm(arr , i);
        System.out.println(newList);
	}
	
	public static void removeDuplicates(List<List<Integer>> list)
    {
		for (List<Integer> element : res) {
            if (!newList.contains(element)) {
                newList.add(element);
                dup = false;
            }
            else
            	dup = true;
        }
    }
	
	public static void findPerm(Integer[] arr , int j ) {
		for(int i=0;i<arr.length;i++) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			List<Integer> l = (Arrays.stream(arr).collect(Collectors.toList()));
			res.add(l);
			removeDuplicates(res);
			if(!dup)
			findPerm(arr , i);
		}
	}
}
