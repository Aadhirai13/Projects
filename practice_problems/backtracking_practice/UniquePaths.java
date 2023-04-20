package backtracking;
import java.util.*;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,3));
	}
	public static List<String> uniquePaths(int m, int n) {
		List<String> list = new ArrayList<>();
		find(m , n , 0 , 0 , "" , list);
        return list;
    }
	
	public static void find(int m , int n , int i , int j , String str , List<String> list) {
		if(i == m-1 && j == n-1) {
			list.add(str);
			return;
		}
		if(i == m || j == n)
			return;
		find(m , n , i , j+1 , str+"h" , list);
		find(m , n , i+1 , j , str+"v" , list);
	}


}
