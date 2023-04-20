package leet;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("1807", "7810"));
	}
	public static String getHint(String secret, String guess) {
        String result = "";
        int cow = 0 , bull = 0;
        for(int i = 0;i < secret.length();i++) {
        	if(guess.indexOf(secret.charAt(i)) == i) {
        		bull++;
//        		secret.repl	
        	}
        }
        return result;
    }

}
