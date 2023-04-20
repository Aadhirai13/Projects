package leet;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}
	public static int maxArea(int[] height) {
        int area = 0,i = 0,j = height.length-1;
        while(i<j) {
        	int total = (j-i) * (Math.min(height[i],height[j]));
        	area = Math.max(area, total);
        	if(height[i] < height[j])
        		i++;
        	else
        		j--;
        }
        return area;
    }

}
