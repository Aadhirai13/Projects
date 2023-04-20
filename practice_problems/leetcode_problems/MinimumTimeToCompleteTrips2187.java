package leet;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips2187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minimumTime(new int[]{5,10,10},9));
	}

	private static long minimumTime(int[] time, int trips) {
		if(time.length == 1)
			return (trips * time[0]);
		Arrays.sort(time);
		long result = 0;
		int start = 1;
		int end = time[time.length-1]*trips;
		int mid = (start+end)/2;
		
		result = checkForResult(time,mid);
		while(result != trips) {
			if(result > trips) {
				end = mid;
				mid = (start+end)/2;
				// check for result
				result = checkForResult(time,mid);
			}
			else {
				start = mid;
				mid = (start+end)/2;
				// check for result
				result = checkForResult(time,mid);
			}
		}
		return mid;
	}

	private static long checkForResult(int[] time, int mid) {
		int result = 0;
		for(int i = 0;i < time.length;i++) {
			result += mid/time[i];
		}
		return result;
	}
	
//	public static long minimumTime(int[] time, int totalTrips) {
//		if(time.length == 1) {
//			return (totalTrips * time[0]);
//		}
//        long result = 0;
//        Arrays.sort(time);
////        if(time.length >= totalTrips) {
////        	if(time[totalTrips-1] >= totalTrips)
////        		return time[totalTrips-1];
////        }
//        boolean[] arr = new boolean[time.length];
//        result += time[0];
//        totalTrips--;
//        while(totalTrips != 0) {
//        	if(isBusAvailable(time,result,arr)) {
//        		totalTrips--;
//        	}
//        	else {
//        		result += time[0];
//        		totalTrips--;
//        	}
//            // arr = new boolean[time.length];
//        }
//        return result;
//    }
//
//	private static int getTripscount(boolean[] arr) {
//		int cnt = 0;
//		for(int i = 1;i < arr.length;i++) {
//			if(arr[i])
//				cnt++;
//		}
//		return cnt;
//	}
//
//	private static boolean isBusAvailable(int[] time, long result, boolean[] arr2) {
//		for(int i = 0;i < time.length;i++) {
//			if(!arr2[i] && (time[i] <= result)) {
//				arr2[i] = true;
//				return true;
//			}
//		}
//		return false;
//	}

}
