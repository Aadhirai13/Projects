package leet;

public class BattleshipsBoard {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] arr = {{'X','.','.','X'} , {'.','.','.','X'} , {'.','.','.','X'} , {'.','.','.','.'}};
		countBattleships(arr);
		System.out.println(count);
	}
	
	public static void countBattleships(char[][] arr) {
       
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length;j++) {
				if(arr[i][j] == 'X') {
					count++;
					arr[i][j] = '.';
					find(i , j , arr);
				}
			}
		}
    }
	
	public static void find(int i , int j , char[][] arr) {
		if((i >= 0 && i < arr.length-1) && arr[i+1][j] == 'X') {
			arr[i+1][j] = '.';
			find(i+1 , j , arr);
		}
		if((j >= 0 && j < arr[0].length-1) && arr[i][j+1] == 'X') {
			arr[i][j+1] = '.';
			find(i , j+1 , arr);
		}
	}

}
