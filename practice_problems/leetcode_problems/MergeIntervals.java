package leet;


public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
		merge(arr);
	}
	public static int[][] merge(int[][] intervals) {
		int result[][] = new int[intervals.length][];
		int res[] = new int[2];
		int i = 0, k=0;
        for(i=0;i<intervals.length-1;i++) {
        	if(intervals[i][1] > intervals[i+1][0]) {
        		intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]); 
        		intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]); 
        	}
        	else {
        		res = intervals[i];
        		result[k++] = res;
        	}
        }
        res = intervals[i];
		result[k++] = res;
        int done[][] = new int[k][];
        for(int x=0;x<k;x++)
        	done[x] = result[x];
        return done;
    }
}
