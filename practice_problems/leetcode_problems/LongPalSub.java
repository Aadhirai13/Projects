package leet;

public class LongPalSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aacabdkacaa"));
	}
	    public static String longestPalindrome(String str) {
	        String orgStr = str,subStr;
	        int lIndex, max = 0,first = -1,last = -1;
	        	for(int i=0;i<str.length();i++){
	                lIndex = str.lastIndexOf(str.charAt(i));
	                while((lIndex+1-i) > max){
	                    subStr = str.substring(i,lIndex+1);
		        	    if((new StringBuilder(subStr).reverse().toString()).equals(subStr)){
	                        max = lIndex+1-i;
	                        first = i;
	                        last = lIndex + 1;
	                        break;
	                    }
	                    else{
	                        str = str.substring(0,lIndex);
	                        lIndex = str.lastIndexOf(str.charAt(i));
	                    }
	                }
	                str = orgStr;                
		        }
			return orgStr.substring(first,last);
	        }


}
