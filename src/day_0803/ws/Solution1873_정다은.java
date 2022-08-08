package day_0803.ws;

import java.util.Scanner;

public class Solution1873_정다은 {
	static int row = 0, col = 0;
	static int car_r = 0, car_c = 0;
	static char[][] board= null;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			row = sc.nextInt();
			col = sc.nextInt();
			
			board= new char[row][col];
			
			for(int i = 0;i < row;i++) {
				String str = sc.next();
				for(int j = 0 ; j < col ; j++) {
					board[i][j] = str.charAt(j);
					if(board[i][j] == '^' || board[i][j] == 'v' || board[i][j] == '<' || board[i][j] == '>') {
						car_r = i;
						car_c = j;
					}
				}
			}
			
			int controlCnt = sc.nextInt();

			char[] controls = sc.next().toCharArray();
			
			for(int i = 0;i < controlCnt ; i++) {
				if(controls[i] != 'S') {
					move(controls[i]);
				}else {
					shoot();
				}
			}
			
			
			System.out.printf("#%d ", tc);
			for(int i = 0;i < row;i++) {
				for(int j = 0 ; j < col ; j++) {
					System.out.printf("%c", board[i][j]);
				}
				System.out.println();
			}
			
			
		}

	}
	
	static void move(char c) {
		int dr = 0, dc = 0;
		char shape = ' ';
		switch(c) {
			case'U': dr = -1; dc = 0; shape='^'; break;
			case'D': dr = 1; dc = 0; shape='v'; break;
			case'L': dr = 0; dc = -1; shape='<'; break;
			case'R': dr = 0; dc = 1; shape='>'; break;
		}	
		board[car_r][car_c] = shape;
		if(car_r + dr < 0 || car_r + dr >= row || car_c + dc < 0 || car_c + dc >= col) {
			return;
		}else {
			if(board[car_r+dr][car_c+dc] == '.') {
				board[car_r][car_c] = '.';
				car_r += dr;
				car_c += dc;
				board[car_r][car_c] = shape;
			}
		}
	}
	
	
	static void shoot() {
		int dr = 0, dc = 0;
		int shell_r = car_r, shell_c = car_c;
		char shape = board[car_r][car_c];
		
		switch(shape) {
			case'^': dr = -1; dc = 0; break;
			case'v': dr = 1; dc = 0; break;
			case'<': dr = 0; dc = -1; break;
			case'>': dr = 0; dc = 1; break;
		}	
		
		while(shell_r >= 0 && shell_r < row && shell_c >= 0 && shell_c < col && board[shell_r][shell_c] != '#') {
			
			if(board[shell_r][shell_c] == '*') {
				board[shell_r][shell_c] = '.'; //평지
				break;
			}
			shell_r += dr;
			shell_c += dc;
		}
	}

}
