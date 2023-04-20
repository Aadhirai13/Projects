package treasure_hunt;

import java.util.*;

public class Modules {
	public static void main(String[] args) {
		getInput();
	}

	public static void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		//dungeon
		int[] dPos = new int[2];
		System.out.println("enter no of rows in dungeon");
		dPos[0] = scanner.nextInt();
		System.out.println("enter no of cols in dungeon");
		dPos[1] = scanner.nextInt();
		
		//adventurer
		int[] aPos = new int[2];
		System.out.println("enter row of adventurer : ");
		aPos[0] = scanner.nextInt();
		System.out.println("enter col of adventurer : ");
		aPos[1] = scanner.nextInt();
		
		//gold
		int[] gPos = new int[2];
		System.out.println("enter row of gold : ");
		gPos[0] = scanner.nextInt();
		System.out.println("enter col of gold : ");
		gPos[1] = scanner.nextInt();
		
		//monster
		int[] mPos = new int[2];
		System.out.println("enter row of monster : ");
		mPos[0] = scanner.nextInt();
		System.out.println("enter col of monster : ");
		mPos[1] = scanner.nextInt();
		
		//trigger
		int[] tPos = new int[2];
		System.out.println("enter row of trigger : ");
		tPos[0] = scanner.nextInt();
		System.out.println("enter col of trigger : ");
		tPos[1] = scanner.nextInt();
		
		//pits
		System.out.println("enter no of pits : ");
		int pitsCnt = scanner.nextInt();
		ArrayList<ArrayList<Integer>> pitPos = new ArrayList<>();
		int j=0;
		if(pitsCnt != 0) {
			for(int i=0;i<pitsCnt;i++) {
				ArrayList<Integer> pPos = new ArrayList<>();
				System.out.println("enter row of pit : " + (i+1));
				int num = scanner.nextInt();
				pPos.add(num);
				System.out.println("enter col of pit : " + (i+1));
				int num1 = scanner.nextInt();
				pPos.add(num1);
				pitPos.add(new ArrayList<>(pPos));
			}
		}
		module1(dPos,aPos,gPos);
		module2(dPos,aPos,gPos,mPos);
//		module3(dPos,aPos,gPos,mPos);
		module4(dPos,aPos,gPos,mPos,tPos);
		module5(dPos,aPos,gPos,pitPos);
		module6(dPos,aPos,gPos,mPos,pitPos);
		module7(dPos,aPos,gPos,mPos,tPos,pitPos);
	}



	private static void module7(int[] dPos, int[] aPos, int[] gPos, int[] mPos, int[] tPos,
			ArrayList<ArrayList<Integer>> pitPos) {
		int size = 0;
		int[] advPos = new int[2];
		int[] monsPos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		LinkedList<int[]> outerMonsPositions = new LinkedList<>();
		LinkedList<int[]> innerMonsPositions = new LinkedList<>();
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		LinkedList<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); // adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		outerMonsPositions.add(mPos); // adding initial position of monster into outer queue
		temp[mPos[0]-1][mPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {			
			// adventurer
			while(!outerAdvPositions.isEmpty()) {
				advPos = outerAdvPositions.poll();
				
				ArrayList<Integer> tempAdvPos = new ArrayList<>();
				tempAdvPos.add(advPos[0]);
				tempAdvPos.add(advPos[1]);
				
				if(pitPos.contains(tempAdvPos)) {
					continue;
				}
				
				if(advPos[0] > 1 && temp[advPos[0]-2][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]-1,advPos[1]});
					temp[advPos[0]-2][advPos[1]-1] = 1;
				}
				
				if(advPos[0] < dPos[0] && temp[advPos[0]][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]+1,advPos[1]});
					temp[advPos[0]][advPos[1]-1] = 1;
				}
				
				if(advPos[1] > 1 && temp[advPos[0]-1][advPos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]-1});
					temp[advPos[0]-1][advPos[1]-2] = 1;
				}
				
				if(advPos[1] < dPos[1] && temp[advPos[0]-1][advPos[1]] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]+1});
					temp[advPos[0]-1][advPos[1]] = 1;
				}
				
				if(Arrays.equals(advPos, gPos)) {
					System.out.println("steps taken in module 6 to reach gold = " + size);
					return;
				}
			}
			
			if(innerAdvPositions.isEmpty()) {
				System.out.println("steps taken in module 6 to reach gold = -1");
				return;
			}
			
			// monster
			while(!outerMonsPositions.isEmpty()) {
				monsPos = outerMonsPositions.poll();
				if(Arrays.equals(monsPos, gPos)) {
					System.out.println("steps taken in module 6 to reach gold = -1" );
					return;
				}
							
				if(monsPos[0] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0]-1,monsPos[1]});
					temp[monsPos[0]-2][monsPos[1]-1] = 1;
				}
				
				if(monsPos[0] < dPos[0]) {
					innerMonsPositions.add(new int[] {monsPos[0]+1,monsPos[1]});
					temp[monsPos[0]][monsPos[1]-1] = 1;
				}
				
				if(monsPos[1] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]-1});
					temp[monsPos[0]-1][monsPos[1]-2] = 1;
				}
			
				if(monsPos[1] < dPos[1]) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]+1});
					temp[monsPos[0]-1][monsPos[1]] = 1;
				}
			}
						
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
			outerMonsPositions = new LinkedList<>(innerMonsPositions);
			innerMonsPositions = new LinkedList<>();
		}
	}

	private static void module6(int[] dPos, int[] aPos, int[] gPos, int[] mPos, ArrayList<ArrayList<Integer>> pitPos) {
		int size = 0;
		int[] advPos = new int[2];
		int[] monsPos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		LinkedList<int[]> outerMonsPositions = new LinkedList<>();
		LinkedList<int[]> innerMonsPositions = new LinkedList<>();
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		LinkedList<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); // adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		outerMonsPositions.add(mPos); // adding initial position of monster into outer queue
		temp[mPos[0]-1][mPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {			
			// adventurer
			while(!outerAdvPositions.isEmpty()) {
				advPos = outerAdvPositions.poll();
				
				ArrayList<Integer> tempAdvPos = new ArrayList<>();
				tempAdvPos.add(advPos[0]);
				tempAdvPos.add(advPos[1]);
				
				if(pitPos.contains(tempAdvPos)) {
					continue;
				}
				
				if(advPos[0] > 1 && temp[advPos[0]-2][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]-1,advPos[1]});
					temp[advPos[0]-2][advPos[1]-1] = 1;
				}
				
				if(advPos[0] < dPos[0] && temp[advPos[0]][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]+1,advPos[1]});
					temp[advPos[0]][advPos[1]-1] = 1;
				}
				
				if(advPos[1] > 1 && temp[advPos[0]-1][advPos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]-1});
					temp[advPos[0]-1][advPos[1]-2] = 1;
				}
				
				if(advPos[1] < dPos[1] && temp[advPos[0]-1][advPos[1]] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]+1});
					temp[advPos[0]-1][advPos[1]] = 1;
				}
				
				if(Arrays.equals(advPos, gPos)) {
					System.out.println("steps taken in module 6 to reach gold = " + size);
					return;
				}
			}
			
			if(innerAdvPositions.isEmpty()) {
				System.out.println("steps taken in module 6 to reach gold = -1");
				return;
			}
			
			// monster
			while(!outerMonsPositions.isEmpty()) {
				monsPos = outerMonsPositions.poll();
				if(Arrays.equals(monsPos, gPos)) {
					System.out.println("steps taken in module 6 to reach gold = -1" );
					return;
				}
							
				if(monsPos[0] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0]-1,monsPos[1]});
					temp[monsPos[0]-2][monsPos[1]-1] = 1;
				}
				
				if(monsPos[0] < dPos[0]) {
					innerMonsPositions.add(new int[] {monsPos[0]+1,monsPos[1]});
					temp[monsPos[0]][monsPos[1]-1] = 1;
				}
				
				if(monsPos[1] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]-1});
					temp[monsPos[0]-1][monsPos[1]-2] = 1;
				}
			
				if(monsPos[1] < dPos[1]) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]+1});
					temp[monsPos[0]-1][monsPos[1]] = 1;
				}
			}
						
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
			outerMonsPositions = new LinkedList<>(innerMonsPositions);
			innerMonsPositions = new LinkedList<>();
		}
	}

	private static void module5(int[] dPos, int[] aPos, int[] gPos, ArrayList<ArrayList<Integer>> pitPos) {
		int size = 0;
		int[] advPos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		LinkedList<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); // adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {
			// adventurer
			while(!outerAdvPositions.isEmpty()) {
				advPos = outerAdvPositions.poll();
				
				ArrayList<Integer> tempAdvPos = new ArrayList<>();
				tempAdvPos.add(advPos[0]);
				tempAdvPos.add(advPos[1]);
				
				if(pitPos.contains(tempAdvPos)) {
					continue;
				}
				
				if(advPos[0] > 1 && temp[advPos[0]-2][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]-1,advPos[1]});
					temp[advPos[0]-2][advPos[1]-1] = 1;
				}
				
				if(advPos[0] < dPos[0] && temp[advPos[0]][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]+1,advPos[1]});
					temp[advPos[0]][advPos[1]-1] = 1;
				}
				
				if(advPos[1] > 1 && temp[advPos[0]-1][advPos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]-1});
					temp[advPos[0]-1][advPos[1]-2] = 1;
				}
				
				if(advPos[1] < dPos[1] && temp[advPos[0]-1][advPos[1]] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]+1});
					temp[advPos[0]-1][advPos[1]] = 1;
				}
				
				if(Arrays.equals(advPos, gPos)) {
					System.out.println("steps taken in module 5 to reach gold = " + size);
					return;
				}
			}
			
			if(innerAdvPositions.isEmpty()) {
				System.out.println("steps taken in module 5 to reach gold = -1");
				return;
			}
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
		}
	}

	private static void module4(int[] dPos, int[] aPos, int[] gPos, int[] mPos, int[] tPos) {
		int size = 0;
		boolean isMonsterAlive = true;
		int[] advPos = new int[2];
		int[] monsPos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		LinkedList<int[]> outerMonsPositions = new LinkedList<>();
		LinkedList<int[]> innerMonsPositions = new LinkedList<>();
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		LinkedList<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); // adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		outerMonsPositions.add(mPos); // adding initial position of monster into outer queue
		temp[mPos[0]-1][mPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {			
			// adventurer
			while(!outerAdvPositions.isEmpty()) {
				advPos = outerAdvPositions.poll();
				if(advPos[0] > 1 && temp[advPos[0]-2][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]-1,advPos[1]});
					temp[advPos[0]-2][advPos[1]-1] = 1;
				}
				
				if(advPos[0] < dPos[0] && temp[advPos[0]][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]+1,advPos[1]});
					temp[advPos[0]][advPos[1]-1] = 1;
				}
				
				if(advPos[1] > 1 && temp[advPos[0]-1][advPos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]-1});
					temp[advPos[0]-1][advPos[1]-2] = 1;
				}
				
				if(advPos[1] < dPos[1] && temp[advPos[0]-1][advPos[1]] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]+1});
					temp[advPos[0]-1][advPos[1]] = 1;
				}
				
				for(int i=0;i<innerAdvPositions.size();i++) {
					if(Arrays.equals(innerAdvPositions.get(i), tPos)) {
						isMonsterAlive = false;
						break;
					}
				}
				
				if(Arrays.equals(advPos, gPos)) {
					System.out.println("steps taken in module 4 to reach gold = " + size);
					return;
				}
			}
			
			// monster
			while(!outerMonsPositions.isEmpty() && isMonsterAlive) {
				monsPos = outerMonsPositions.poll();
				if(Arrays.equals(monsPos, gPos)) {
					System.out.println("steps taken in module 4 to reach gold = -1" );
					return;
				}
							
				if(monsPos[0] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0]-1,monsPos[1]});
					temp[monsPos[0]-2][monsPos[1]-1] = 1;
				}
				
				if(monsPos[0] < dPos[0]) {
					innerMonsPositions.add(new int[] {monsPos[0]+1,monsPos[1]});
					temp[monsPos[0]][monsPos[1]-1] = 1;
				}
				
				if(monsPos[1] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]-1});
					temp[monsPos[0]-1][monsPos[1]-2] = 1;
				}
			
				if(monsPos[1] < dPos[1]) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]+1});
					temp[monsPos[0]-1][monsPos[1]] = 1;
				}
			}
						
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
			outerMonsPositions = new LinkedList<>(innerMonsPositions);
			innerMonsPositions = new LinkedList<>();
		}
	}

	private static void module2(int[] dPos, int[] aPos, int[] gPos, int[] mPos) {
		int size = 0;
		int[] advPos = new int[2];
		int[] monsPos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		LinkedList<int[]> outerMonsPositions = new LinkedList<>();
		LinkedList<int[]> innerMonsPositions = new LinkedList<>();
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		LinkedList<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); // adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		outerMonsPositions.add(mPos); // adding initial position of monster into outer queue
		temp[mPos[0]-1][mPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {			
			// adventurer
			while(!outerAdvPositions.isEmpty()) {
				advPos = outerAdvPositions.poll();
				if(advPos[0] > 1 && temp[advPos[0]-2][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]-1,advPos[1]});
					temp[advPos[0]-2][advPos[1]-1] = 1;
				}
				
				if(advPos[0] < dPos[0] && temp[advPos[0]][advPos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {advPos[0]+1,advPos[1]});
					temp[advPos[0]][advPos[1]-1] = 1;
				}
				
				if(advPos[1] > 1 && temp[advPos[0]-1][advPos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]-1});
					temp[advPos[0]-1][advPos[1]-2] = 1;
				}
				
				if(advPos[1] < dPos[1] && temp[advPos[0]-1][advPos[1]] != 1) {
					innerAdvPositions.add(new int[] {advPos[0],advPos[1]+1});
					temp[advPos[0]-1][advPos[1]] = 1;
				}
				
				if(Arrays.equals(advPos, gPos)) {
					System.out.println("steps taken in module 2 to reach gold = " + size);
					return;
				}
			}
			
			// monster
			while(!outerMonsPositions.isEmpty()) {
				monsPos = outerMonsPositions.poll();
				if(Arrays.equals(monsPos, gPos)) {
					System.out.println("steps taken in module 2 to reach gold = -1" );
					return;
				}
							
				if(monsPos[0] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0]-1,monsPos[1]});
					temp[monsPos[0]-2][monsPos[1]-1] = 1;
				}
				
				if(monsPos[0] < dPos[0]) {
					innerMonsPositions.add(new int[] {monsPos[0]+1,monsPos[1]});
					temp[monsPos[0]][monsPos[1]-1] = 1;
				}
				
				if(monsPos[1] > 1) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]-1});
					temp[monsPos[0]-1][monsPos[1]-2] = 1;
				}
			
				if(monsPos[1] < dPos[1]) {
					innerMonsPositions.add(new int[] {monsPos[0],monsPos[1]+1});
					temp[monsPos[0]-1][monsPos[1]] = 1;
				}
			}
						
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
			outerMonsPositions = new LinkedList<>(innerMonsPositions);
			innerMonsPositions = new LinkedList<>();
		}
	}

	private static void module1(int[] dPos, int[] aPos, int[] gPos) {
		int size = 0;
		int[] pos = new int[2];
		int[][] temp = new int[dPos[0]][dPos[1]]; // for storing visited positions
		Queue<int[]> outerAdvPositions = new LinkedList<>();
		Queue<int[]> innerAdvPositions = new LinkedList<>();
		outerAdvPositions.add(aPos); //adding initial position of adventurer into outer queue
		temp[aPos[0]-1][aPos[1]-1] = 1; // changing initial position to visited
		
		while(true) {
			while(!outerAdvPositions.isEmpty()) {
				pos = outerAdvPositions.poll();
				
				if(pos[0] > 1 && temp[pos[0]-2][pos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {pos[0]-1,pos[1]});
					temp[pos[0]-2][pos[1]-1] = 1;
				}
				
				if(pos[0] < dPos[0] && temp[pos[0]][pos[1]-1] != 1) {
					innerAdvPositions.add(new int[] {pos[0]+1,pos[1]});
					temp[pos[0]][pos[1]-1] = 1;
				}
				
				if(pos[1] > 1 && temp[pos[0]-1][pos[1]-2] != 1) {
					innerAdvPositions.add(new int[] {pos[0],pos[1]-1});
					temp[pos[0]-1][pos[1]-2] = 1;
				}
				
				if(pos[1] < dPos[1] && temp[pos[0]-1][pos[1]] != 1) {
					innerAdvPositions.add(new int[] {pos[0],pos[1]+1});
					temp[pos[0]-1][pos[1]] = 1;
				}
				
				if(Arrays.equals(pos, gPos)) {
					System.out.println("steps taken in module 1 to reach gold = " + size);
					return;
				}
			}
			size++;
			outerAdvPositions = new LinkedList<>(innerAdvPositions);
			innerAdvPositions = new LinkedList<>();
		}
	}
}
