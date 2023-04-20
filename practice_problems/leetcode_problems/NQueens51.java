package hardleet;

import java.util.*;

public class NQueens51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(8).size());
	}
	
	public static List<List<String>> solveNQueens(int n) {

		List<List<String>> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        if(n == 1){
            list2.add("Q");
            list.add(list2);
            return list;
        }
        
        String[][] matrix = new String[n][n];
        
        for(int i = 0;i < n;i++) {
        	for(int j = 0;j < n;j++) {
        		matrix[i][j] = ".";
        	}
        }
        helper(n,0,0,matrix,list2,list);
        return list;
	}

	private static boolean helper(int n,int i, int j, String[][] matrix, List<String> list2, List<List<String>> list) {	
		
		if(i == n) {
			String str = "";
			for(int x = 0;x < n;x++) {
	        	for(int y = 0;y < n;y++) {
	        		str += matrix[x][y];
	        	}
	        	list2.add(str);
	        	str = "";
	        }
	        list.add(new ArrayList<>(list2));
	        list2.clear();
	        return false;
		}
		
		for(int x=0;x<n;x++) {
			if(checkForSafe(n,i,x,matrix)) {
				matrix[i][x] = "Q";
				if(helper(n,i+1,j,matrix,list2,list))
					return true;
				else
					matrix[i][x] = ".";
			}
		}
		return false;
	}
	private static boolean checkForSafe(int n, int i, int j, String[][] matrix) {
		return !(isColContains(n,j,matrix) || isAnyDiagonalContains(n,i,j,matrix));
	}

	private static boolean isAnyDiagonalContains(int n, int i, int j, String[][] matrix) {
		int x = i, y = j;
	
		// top left diagonal
		while(x > 0 && y > 0) {
			if(matrix[--x][--y].equals("Q"))
				return true;
		}
		x = i;y = j;
	
		// top right diagonal 
		while(x > 0 && y < (n-1)) {
			if(matrix[--x][++y].equals("Q"))
				return true;
		}
		x = i;y = j;
		
		// bottom left diagonal
//		while(x < (n-1) && y > 0) {
//			if(matrix[++x][--y].equals("Q"))
//				return true;
//		}	
//		x = i;y = j;
//		
//		// bottom right diagonal
//		while(x < (n-1) && y < (n-1)) {
//			if(matrix[++x][++y].equals("Q"))
//				return true;
//		}
		
		return false;
	}
	
	private static boolean isColContains(int n, int j, String[][] matrix) {
		for(int row = 0;row < n;row++) {
			if(matrix[row][j].equals("Q"))
				return true;
		}
		return false;
	}
	
	private static boolean isRowContains(int n, int i, String[][] matrix) {
		for(int col = 0;col < n;col++) {
			if(matrix[i][col].equals("Q"))
				return true;
		}
		return false;
	}

}
























        
//        for(int i = 0;i < n;i++) {
//        	for(int j = 0;j < n;j++) {
//        		helper(n, i, j, matrix, list, list2);
//        	}
//        }
        
//         2nd method
//	        for(int i = 0;i < n;i++) {
//        	int row = 0;
//        	while(row < n) {
//	        		if(helper(n, 0, matrix)) {
//	        			String str = "";
//	        	        for(int x = 0;x < n;x++) {
//	        	        	for(int y = 0;y < n;y++) {
//	        	        		str += matrix[x][y];
//	        	        		if(str.charAt(0) == 'Q')
//		        	        		row = x + 1;
//	        	        	}
//	    
//	        	        	list2.add(str);
//	        	        	str = "";
//	        	        }
//	        	        list.add(new ArrayList<>(list2));
//	        	        list2.clear();
//	        	        for(int x = 0;x < n;x++)
//	            			Arrays.fill(matrix[x],".");
//	        		}
//        	}
//	        }
	        
//	        for(int i = 0;i < n;i++) {
//	        	for(int j = 0;j < n;j++) {
//	        		System.out.print(matrix[i][j]);
//	        	}
//	        	System.out.println();
//	        }
	        
//	        return list;
//    }

//	private static void helper(int n, int i, int j, String[][] matrix, List<List<String>> list, List<String> list2) {
//		if(isRowContains(n,i,matrix) || isColContains(n,j,matrix) || isAnyDiagonalContains(n,i,j,matrix)) {
//			list2.add(matrix[i][j]);
//			if(j == n-1) {
//				list.add(new ArrayList<>(list2));
//			}
//			return;
//		}
//		
//		matrix[i][j] = "Q";
//		list2.add(matrix[i][j]);
//		aa:
//		while(i < n && j < n-1) {
//			helper(n, i, ++j, matrix, list, list2);
//			if(j == n-1) {
//				i = i+1;
//				j = -1;
//				list2.clear();
//				continue aa;
//			}
//		}
//	}
	
	// 2nd method
//	private static boolean helper(int n, int j, String[][] matrix) {
//		if(j == n) {
//			return true;
//		}
//		
//		for(int i = 0;i < n;i++) {
//			if(checkForSafe(n,i,j,matrix)) {
//				matrix[i][j] = "Q";
//				if(helper(n,j+1,matrix))
//					return true;
//				matrix[i][j] = ".";
//			}
//		}
//		return false;
//	}

	// 2nd method
//	private static boolean checkForSafe(int n, int i, int j, String[][] matrix) {
//	return !(isRowContains(n,i,matrix) || isColContains(n,j,matrix) || isAnyDiagonalContains(n,i,j,matrix));
//}
//
//private static boolean isAnyDiagonalContains(int n, int i, int j, String[][] matrix) {
//	int x = i, y = j;
//	
//	// top left diagonal
//	while(x > 0 && y > 0) {
//		if(matrix[--x][--y].equals("Q"))
//			return true;
//	}
//	x = i;y = j;
//	
//	// top right diagonal 
//	while(x > 0 && y < (n-1)) {
//		if(matrix[--x][++y].equals("Q"))
//			return true;
//	}
//	x = i;y = j;
//	
//	// bottom left diagonal
//	while(x < (n-1) && y > 0) {
//		if(matrix[++x][--y].equals("Q"))
//			return true;
//	}	
//	x = i;y = j;
//	
//	// bottom right diagonal
//	while(x < (n-1) && y < (n-1)) {
//		if(matrix[++x][++y].equals("Q"))
//			return true;
//	}
//	
//	return false;
//}
//
//	private static boolean isColContains(int n, int j, String[][] matrix) {
//		for(int row = 0;row < n;row++) {
//			if(matrix[row][j].equals("Q"))
//				return true;
//		}
//		return false;
//	}
//
//	private static boolean isRowContains(int n, int i, String[][] matrix) {
//		for(int col = 0;col < n;col++) {
//			if(matrix[i][col].equals("Q"))
//				return true;
//		}
//		return false;
//	}
