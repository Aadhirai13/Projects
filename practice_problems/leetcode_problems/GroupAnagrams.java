package leet;
import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(arr));

	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> h = new HashMap<>();
        
        for(String s : strs) {
        	String ans = sort(s);
        	List<String> sub = new ArrayList<>();
        	sub.add(s);
        	if(h.get(ans) != null) {
        		List<String> sub1 = h.get(ans);
        		sub1.add(s);
        		h.put(ans , sub1);
        	}
        	else {
        		List<String> sub2 = new ArrayList<>(sub);
        		h.put(ans ,sub2);
        	}
        	
        }
        	for(Map.Entry<String,List<String>> entry : h.entrySet()) {
            	list.add(entry.getValue());
            }   
             
        return list;
    }
	
	public static String sort(String s) {
		char tempArray[] = s.toCharArray();
    	Arrays.sort(tempArray);
    	String ans = new String(tempArray);
    	return ans;
	}

}
