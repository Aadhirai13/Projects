package leet;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(arr);
	}
	public static void rotate(int[][] matrix) {
        for(int a[] : matrix) {
        	for(int b : a)
        		System.out.print(b);
        	System.out.println();
        }
        for(int i=0;i<matrix.length;i++) {
        	for(int j=i;j<matrix[0].length;j++) {
        		matrix[i][j] = (matrix[i][j] + matrix[j][i]) - (matrix[j][i] = matrix[i][j]);
        	}
        }
        for(int i=0;i<matrix.length;i++) {
        	matrix[i] = swap(matrix[i]);
        }
        
        for(int a[] : matrix) {
        	for(int b : a)
        		System.out.print(b);
        	System.out.println();
        }
    }
	
	public static int[] swap(int arr[]) {
		int i=0,j=arr.length-1;
		while(i<j) {
			arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
			i++;
			j--;
		}
		return arr;
	}
}
