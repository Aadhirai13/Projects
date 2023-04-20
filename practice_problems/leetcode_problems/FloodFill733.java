package leet;


public class FloodFill733 {

	public static void main(String args[]) {
		int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] res = floodFill(arr, 1, 1, 2);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if(image[sr][sc] == color)
			return image;
		helper(image,sr,sc,color,image[sr][sc]);
        return image;
    }

	private static void helper(int[][] image, int sr, int sc, int color, int val) {
		if((sr < 0) || (sc < 0) || (sr > image.length-1) || (sc > image[0].length-1) || image[sr][sc] != val) {
			return;
		}
		image[sr][sc] = color;
		helper(image,sr+1,sc,color,val);
		helper(image,sr,sc+1,color,val);
		helper(image,sr-1,sc,color,val);
		helper(image,sr,sc-1,color,val);
	}
}
