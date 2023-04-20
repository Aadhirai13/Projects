package leet;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("a   good   example"));
	}
	public static String reverseWords(String s) {
		s = s.trim();
		char arr[]=s.toCharArray();		
		int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ' && arr[i] != ' ') {
                reverse(arr, i, j-1);
                i = j + 1;
            }
        }
        reverse(arr,i,arr.length - 1);
        reverse(arr,0,arr.length - 1);
        return new String(arr).trim();
	}
		
	static void reverse(char str[], int s, int e)
    {
		char temp;
        while (s <= e) {
            temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }
}

//if(arr.length==1)
//  return arr[0];
//
//String result[]=new String[arr.length-1];
//for(int i=0;i<result.length;i++){
//  result[i]=arr[i];
//}
//StringBuffer sb = new StringBuffer();
//for(int i = 0; i < result.length; i++) {
// sb.append(result[i] + " ");
//}
//return arr[arr.length-1] +" "+ reverseWords(sb.toString());
