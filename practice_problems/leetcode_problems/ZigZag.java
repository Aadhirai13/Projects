package leet;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(convert("PAYPALISHIRING" , 4));
		convert("PAYPALISHIRING" , 4);
	}
	public static void convert(String s, int numRows) {
        int i = 0, x = 0, col = 0;
        String newStr = "";
//        if(s.length() < 3)
//            return s;
        while(i < s.length()){
            i += numRows;
            col++;
            i += (numRows-2);
            col += numRows - 2;
        }
        String arr[][] = new String[numRows][col];
        aa:
        for(int j=0;j<=col;j++){
            for(int k=0;k<numRows;k++){
                if((j % (numRows - 1) == 0) || ((k + j) % (numRows - 1) == 0)){
                    arr[k][j] = s.substring(x,x+1);
                    x++;
                    if(x == s.length())
                        break aa;
                }
                else
                    arr[k][j] = "";
            }
        }
        for(String[] ch : arr){
            for(String c : ch){
                
                if(c == null )
                   continue;
                System.out.print(c);
        }
        
}
//return newStr;
}

}
