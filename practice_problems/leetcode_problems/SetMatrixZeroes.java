package leet;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,2,3},{3,0,5},{1,2,3},{0,8,9}};
		setZeroes(a);
	}
	public static void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length; 
        int arr[][] = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, arr[i], 0, matrix[i].length);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
            	if(arr[i][j] == 0) {
            		for(int r=0;r<row;r++) 
            			matrix[r][j] = 0;
            		for(int c=0;c<col;c++) 
            			matrix[i][c] = 0;
            	}
            }
        }
        for(int[] a : matrix) {
        	for(int b : a)
        		System.out.print(b);
        	System.out.println();
        }
    }

}
