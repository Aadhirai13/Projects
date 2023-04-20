package leet;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,0,0,0};
		int[] arr2 = {2,5,6};
		int a = 3,b = 3;
		merge(arr1,a,arr2,b);
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 int i = m - 1;   
		    int j = n - 1;  
		    int k = m + n - 1; 

		    while (j >= 0)
		      if (i >= 0 && nums1[i] > nums2[j])
		        nums1[k--] = nums1[i--];
		      else
		        nums1[k--] = nums2[j--];
    }

}
