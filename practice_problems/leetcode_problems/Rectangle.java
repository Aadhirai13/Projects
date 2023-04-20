package leet;

public class Rectangle{
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,1,1,0,0,1,1},{1,1,1,0,0,1,1},{1,0,0,0,0,1,1},
				{0,0,0,0,0,0,0},{1,1,0,0,1,1,1},{1,1,0,0,1,1,0},{1,1,0,0,1,1,0}};
		int[] max = new int[1];
		int maxDiff = 0;
		for(int i=0;i<arr.length-1;i++) {
			checkForOne(arr,0,0,0,6,max);
			maxDiff = max[0] > maxDiff ? max[0] : maxDiff;
		}
		System.out.println(count + " rectangles - max Size - " + maxDiff);
	}
	public static void checkForOne(int a[][],int startRow,int row,int s,int e,int[] max) {
		int start[] = {-1,-1,-1,-1,-1,-1,-1};
		int end[] = {-1,-1,-1,-1,-1,-1,-1};
		for(int j=s;j<=e;j++) {
			if(a[row][j] == 1) {
				if(start[row] == -1)
					start[row] = j;
				continue;
			}
			else {
				end[row] = j-1;
				if((start[row] != end[row]) && (start[row] != -1 && end[row] != -1)) {
					int r = row+1;
					checkForOne(a,startRow,r,start[row],end[row],max);
				}
				else {
					int size = (end[row]-start[row]+1) * (row-1-startRow+1);
					if(size > max[0])
						max[0] = size;
					count++;
				}
					
			}
			
		}
	}

}
