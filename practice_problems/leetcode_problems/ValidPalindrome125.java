package leet;

public class ValidPalindrome125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("0P"));
	}
	public static boolean isPalindrome(String s) {
		if(s.length()<2)
			return true;
		s = s.toLowerCase();
        char[] arr = s.toCharArray();
        char[] arr1 = s.toCharArray();
        int k=0;
        for(int i=0;i<arr.length;i++) {
        	if((arr[i]>='a' && arr[i]<='z') || Character.isDigit(arr[i])) 
        		arr1[k++] = arr[i];
        }
        StringBuilder sb = new StringBuilder(new String(arr1).substring(0,k));
        if(new String(arr1).substring(0,k).equals(sb.reverse().toString()))
        	return true;
        else 
        	return false;
    }
}
