package leet;

//Leet1
public class Leet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,1,2,3,3,4,5};
		int count = 1,j = 0;
		for(int i=0;i<arr.length && j<arr.length-1;) {
			if(arr[i] == arr[j] && count < 2) {
				j++;
				i++;
				count++;
			}
			else if(arr[i] == arr[j] && count == 2 ) {
				arr[i] = arr[j];
				j++;
			}
			else {
				count = 1;
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		for(int item : arr)
			System.out.print(item);
	}

}
