package leet;


public class CanPlaceFlowers605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1,0,0}, 2));
	}
	
	public static boolean canPlaceFlowers(int[] arr, int n) {
		int cnt = 0;

        if(arr.length < 1){
            return false;
        }

        if(arr.length == 1){
            if(arr[0] == 1){
                if(n==1)
                    return false;
                else
                    return true;
            }
            else{
                return true;
            }
        }

        if(arr[0] == 0 && arr[1] == 0){
            arr[0] = 1;
            cnt++;
        }
        
        for(int i=1;i<arr.length-1;i++) {
        	if(arr[i] == 0 && arr[i-1] == 0 && arr[i+1] == 0) {
        		arr[i] = 1;
        		cnt++;
        	}
        }

        if(arr[arr.length-1] == 0 && arr[arr.length-2] == 0){
            arr[arr.length-1] = 1;
            cnt++;
        }
    
        if(cnt >= n)
        	return true;
        else
        	return false;
    }

}
