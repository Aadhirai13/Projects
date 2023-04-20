package leet;

//Leet1
public class Leet {
	public static void main(String args[]) {
		int arr[] = {-3,-1,0,0,0,3,3};
		int j = 1;
		for(int i=0;i<arr.length-1 && j<arr.length;) {
			if(arr[i] == arr[j]) {
				arr[i] = arr[j];
				j++;
			}
			else {
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		for(int m : arr)
			System.out.println(m);
	}

}
