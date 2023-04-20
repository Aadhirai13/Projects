package leet;
import java.util.*;

public class FruitsIntoBaskets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {0,1,2,2};
		System.out.println(totalFruit(arr));
	}
	
	public static int totalFruit(int[] arr) {
        int ans = 0 , max = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        	int j = 0;
	        for(int i=j;i<arr.length;i++) {
	        	if(h.get(arr[i]) == null) {
	        		h.put(arr[i], 1);
	        		ans++;
	        	}
	        	else {
	        		ans++;
	        		h.put(arr[i], h.get(arr[i])+1);
	        	}
	        	if(h.size() > 2) {
	        		ans--;
	        		max = Math.max(max, ans);
	        		j++;
	        		i = j;
	        		i--;
	        		ans = 0;
	        		h.clear();
	        	}
	        		
	        }
	        max = Math.max(max, ans);
        return max;
    }

}
