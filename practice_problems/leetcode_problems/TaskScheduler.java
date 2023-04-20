package leet;
import java.util.Arrays;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'A','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		System.out.println(leastInterval(arr, 29));
	}
	
	public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(int i = 0;i < tasks.length;i++){
            arr[tasks[i]-65]++;
        }
        Arrays.sort(arr);
        int taskCnt = 0;
        outer:
        while(arr[25] != 0){
        	int temp = n;
            for(int i = 25;i >= 25 - n;i--){
            	if(i < 0)
            		i = temp+1;
            	if(arr[25] == 0) {
            		taskCnt += Arrays.stream(arr).sum();
            		break outer;
            	}
            	if(i == 25 && arr[i] == 1 && arr[i-1] == 0){
                    taskCnt++;
                    break outer;
                }if(arr[i] == 0){
                	taskCnt++;
                	taskCnt += temp;
                	i = 26;
                	temp -= temp;
                    continue outer;
                }
                taskCnt++;
                temp--;
                arr[i] -= 1;
                if(i == 0 && temp > 0) {
                    i = 26;
                    taskCnt += temp;
                    taskCnt++;
                }
                else if(i == 0)
                    i = 26;
            }
            Arrays.sort(arr);
        }
        return taskCnt;
    }

}
