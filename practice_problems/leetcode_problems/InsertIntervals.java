package leet;
import java.util.Arrays;

public class InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int intervals[] = {4,8};
		insert(arr,intervals);
	}
	public static int[][] insert(int[][] arr , int[] intervals) {
		
		int result[][] = new int[arr.length + 1][];
		if(arr.length == 0) {
			result[0] = intervals;
			int done[][] = new int[1][];
			done[0] = result[0];
			return done;
		}
		if(arr.length == 1) {
			result[0][0] = Math.min(intervals[0], arr[0][0]);
			result[0][1] = Math.min(intervals[1], arr[0][1]);
			int done[][] = new int[1][];
			done[0] = result[0];
			return done;
		}
	
		int res[] = new int[2];
		int i = 0, k=0;
        for(i=0;i<arr.length - 1;i++) {
        	if(arr[i][0] <= intervals[0] && arr[i+1][0] > intervals[0]) {
        		res[0] = arr[i][0];
        		int j = i+1;
        		while(j < arr.length) {
        			if(arr[j][0] <= intervals[1] && arr[j+1][0] > intervals[1]) {
        				res[1] = arr[j][1];
                		i = j;
        				break;
        			}
        			res[1] = intervals[1];
        			result[k++] = res;
        			j++;
        		}
        	}
        	else {
//        		res = arr[i];
        		result[k++] = arr[i];
        	}
        }
        res = arr[i];
		result[k++] = res;
        int done[][] = new int[k][];
        for(int x=0;x<k;x++)
        	done[x] = result[x];
        for(int x=0;x<k;x++)
        	System.out.println(Arrays.toString(done[x]));
        return done;
    }

}
