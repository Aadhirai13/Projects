package leet;
import java.util.*;

//Leet1
public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-5,-5,-1,0,0,0,3,3};
		System.out.println(removeDuplicates(nums));
	}
	
	    public static int removeDuplicates(int[] nums) {
	        int index = 0;
	        LinkedHashMap<Integer,Integer> h1 = new LinkedHashMap<Integer,Integer>();
	        for(int num : nums){
	            if(h1.containsKey(num))
	                h1.put(num,h1.get(num)+1);
	            else
	                h1.put(num,1);
	        }
	        for(Map.Entry<Integer,Integer> entry : h1.entrySet()){
	            int value = (int)entry.getValue();
	            if(value >= 2){
	                for(int i=1;i<=2;i++){
	                    nums[index] = (int)entry.getKey();
	                    index++;
	                }
	            }
	            else{
	                nums[index] = (int)entry.getKey();
	                index++;
	            }
	        }
	        System.out.println(Arrays.toString(nums));
	        return index;
	    }
	
}
