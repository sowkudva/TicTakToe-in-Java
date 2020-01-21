package Youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tiktaktoe {
	
	//global variable to store player positions
	
	static ArrayList<Integer> playerPos = new ArrayList<>();
	static ArrayList<Integer> cpuPosi = new ArrayList<>();
	static boolean isValid=true;
	
	public static void main (String[] args) {
		
		char[][] gameBoard = {{' ','|',' ','|',' '},
							  {'-','+','-','+','-'},
							  {' ','|',' ','|',' '},
							  {'-','+','-','+','-'},
							  {' ','|',' ','|',' '}};
	
		printGameBoard(gameBoard);
		
		//Take input from user 
		Scanner sc = new Scanner(System.in);
		
		while(isValid) {
			
			System.out.println("Enter the position 1-9:");
			int pos = sc.nextInt();
			
			
			while(playerPos.contains(pos)) {
				pos = sc.nextInt();
			}
			
			printLetterInPos(gameBoard,pos,"Player");
			
			Random random = new Random();
			int cpuPos = random.nextInt(9)+1;
			
			while(cpuPosi.contains(cpuPos) || playerPos.contains(cpuPos)) {
				cpuPos = random.nextInt(9)+1;
			}
			
			
			printLetterInPos(gameBoard,cpuPos,"cpu");
			printGameBoard(gameBoard);
			
			String winner = checkWinner();
			System.out.println(winner);
			
			
			
		}
		
		//clear(gameBoard);
		
		
		
	}
		
		
		
	public static void printGameBoard(char[][] gameBoard) {
		
		for(char[] row : gameBoard) {
			
			for(char c : row) {
				
				System.out.print(c);
			}
			System.out.println();
		}
		
	}
	
	public static void printLetterInPos(char[][] gameBoard, int pos, String user) {
		
		char symbol= ' ';
		if(user.equals("Player")) {
			symbol='X';
			playerPos.add(pos);
		}
		else {
			symbol='0';
			cpuPosi.add(pos);
			
		}
			
		switch(pos) {
				case 1: gameBoard[0][0]=symbol;
				break;
				case 2: gameBoard[0][2]=symbol;
				break;
				case 3: gameBoard[0][4]=symbol;
				break;
				case 4: gameBoard[2][0]=symbol;
				break;
				case 5: gameBoard[2][2]=symbol;
				break;
				case 6: gameBoard[2][4]=symbol;
				break;
				case 7: gameBoard[4][0]=symbol;
				break;
				case 8: gameBoard[4][2]=symbol;
				break;
				case 9: gameBoard[4][4]=symbol;
				break;
				default:
					break;
			
		}
	}
	
	public static void clear(char[][] gameBoard) {
		
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard[i].length; j++	) {
				gameBoard[i][j] =' ';
				j++;
			}
			i++;
		}
		
	}
	
	
	
    //keeps track of player and CPU positions to see who is the winner
	public static String checkWinner() {
		
		//win conditions
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow= Arrays.asList(7,8,9);
		List leftCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,5,8);
		List rightCol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(3,5,7);
		
		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		
		
		for(List l : winningConditions) {
			
			if(playerPos.containsAll(l)) {
				isValid=false;
				
				return "********Congragulations Player Wins******";
				
			}
			else if(cpuPosi.containsAll(l)) {
				isValid=false;
				return "**********   CPU wins  *************";
			}
			else if(playerPos.size() + cpuPosi.size() == 9) {
				
				return "*****Better luck next time CAT! ****";
			}
		}
		
		
		return " ";
		
	}

}