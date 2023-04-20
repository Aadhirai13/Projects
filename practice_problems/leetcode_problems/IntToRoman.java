package leet;

public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(2000));
	}
	public static String intToRoman(int num) {
        int numbers[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String roman[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        String s = "";
        for(int i = numbers.length-1 ; i>=0 ; i--) {
        	if(num == 0)
        		break;
        	if(numbers[i] <= num) {
        		s += roman[i];
        		num -= numbers[i];
        		i = numbers.length;
        	}
        }
        return s;
    }

}
