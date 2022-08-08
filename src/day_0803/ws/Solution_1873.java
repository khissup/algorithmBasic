package day_0803.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input1873.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = st.nextToken().charAt(0) - '0';
			int W = st.nextToken().charAt(0) - '0';
			char[][] map = new char[H][W];
			int[] position = new int[3]; // 0, 1 위치정보 2 방향 (0 위 1 아래 2 왼쪽 3 오른쪽)
			
			for(int i = 0; i < H; i++) {
				char[] temp = br.readLine().toCharArray();
			}

			int actionCount = Integer.parseInt(br.readLine());
			char[] action = br.readLine().toCharArray();
			for(int i = 0; i < action.length; i++) {
				move(map, position, action[i]);
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}
	public static void move(char[][] state, int[] position, char input) {
		int y = position[0];
		int x = position[1];
		int direction = position[2];
		// (0 위 1 아래 2 왼쪽 3 오른쪽)
		switch(input) {
		case 'U':
			if(y > 0) {
				if(state[y - 1][x] != '*' && state[y - 1][x] != '#' && state[y - 1][x] != '-') {
					y--;
				}
			}
			break;
		case 'D':
			if(y < state.length - 1) {
				if(state[y + 1][x] != '*' && state[y + 1][x] != '#' && state[y + 1][x] != '-') {
					y++;
				}
			}
			break;
		case 'L':
			if(x > 0) {
				if(state[y][x - 1] != '*' && state[y][x - 1] != '#' && state[y][x - 1] != '-') {
					x--;
				}
			}
			break;
		case 'R':
			if(x < state[0].length - 1) {
				if(state[y][x + 1] != '*' && state[y][x + 1] != '#' && state[y][x + 1] != '-') {
					x++;
				}
			}
			break;
		case 'S':
			
			if(direction == 0) {
				if(y > 0) {
					for(int i = y; i >= 0; i--) {
						if(state[y - 1][x] == '#') {
							break;
						} else if (state[y - 1][x] == '*') {
							state[y - 1][x] = '.';
							y--;
							break;
						} else if(state[y - 1][x] == '.') {
							state[y - 1][x] = '.';
							y--;
						}
					}
				}
			} else if(direction == 1) {
				if(y < state.length - 1) {
					for(int i = y; i < state.length - 1; i++) {
						if(state[y + 1][x] == '#') {
							break;
						} else if (state[y - 1][x] == '*') {
							state[y + 1][x] = '.';
							y++;
							break;
						} else if(state[y - 1][x] == '.') {
							state[y + 1][x] = '.';
							y++;
						}
					}
				}
			} else if(direction == 2) {
				if(x > 0) {
					for(int i = x; i >= 0; i--) {
						if(state[y][x - 1] == '#') {
							break;
						} else if (state[y][x - 1] == '*') {
							state[y][x - 1] = '.';
							x--;
							break;
						} else if(state[y][x - 1] == '.') {
							state[y][x - 1] = '.';
							x--;
						}
					}
				}
			} else if(direction == 3) {
				if(x < state[0].length - 1) {
					for(int i = x; i < state[0].length - 1; i++) {
						if(state[y][x + 1] == '#') {
							break;
						} else if (state[y][x - 1] == '*') {
							state[y][x + 1] = '.';
							x++;
							break;
						} else if(state[y][x - 1] == '.') {
							state[y][x + 1] = '.';
							x++;
						}
					}
				}
			}
		}
	}
}
// 헛짓거리 ㅠㅠ
//	public static Map<Character[][], Integer[]> move(Map<Character[][], Integer[]> state, char input) {
//		switch(input) {
//		
//	}
// Map<Character[][], Integer[]> state = new HashMap<Character[][], Integer[]>();
// Character[][] map = new Character[H][W];
// Integer[] position = new Integer[2];
// state.put(map, position);