package leet;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1};
		System.out.println(largestRectangleArea(arr));

	}
	
	public static int largestRectangleArea(int[] heights) {
        int resArea = 0 , j = 0, k = 0;
        for(int i=0;i<heights.length;i++) {
        	int area = heights[i];		
        	j = i - 1;
        	while(j>=0 && heights[j]>=heights[i]) {
        		area += heights[i];
        		j--;
        	}

        	k = i + 1;
        	while(k<heights.length && heights[k]>=heights[i]) {
        		area += heights[i];
        		k++;
        	}
        	
        	resArea = Math.max(resArea, area);
        	
        }
        return resArea;
    }

}
