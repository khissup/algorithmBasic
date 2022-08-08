package day_0802.ws;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2805 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/input2805.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String msg = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = msg.charAt(j) - '0';
				}
			}
			System.out.printf("#%d %d\n", t, manhaton(N, arr));
		}
	}
	
	// 맨하튼 거리 공식 이용
	// (x1, y1) (x2, y2)  =>  d = |x1-x2| + |y1-y2|
	public static int manhaton(int N, int[][] arr) {
		int sum = 0;
		int half = N / 2;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(Math.abs(half - r) + Math.abs(half - c) <= half) {
					sum +=arr[r][c];
				}
			}
		}
		return sum;
	}
}
