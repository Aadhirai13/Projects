package leet;

public class StringCompression443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'a','a','a','b','c','c','c','c'};
		int j = 1;
		int frequency = 1;
		String result = "";
		for(int i = 0;i < arr.length - 1;) {
			while((j < arr.length) && arr[i] == arr[j]) {
				frequency++;
				j++;
			}
			if(frequency == 1)
				result += arr[i];
			else
				result += arr[i] + "" + frequency;
			i = j;
			j++;
			frequency = 1;
		}
		int length = result.length();
		for(int i = 0;i < result.length();i++) {
			arr[i] = result.charAt(i);
		}
		System.out.println(result);
	}

}
