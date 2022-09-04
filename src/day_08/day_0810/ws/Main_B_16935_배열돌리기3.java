package day_08.day_0810.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/16935
public class Main_B_16935_배열돌리기3 {
	static int[][] Arr;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		// input
		System.setIn(new FileInputStream("input/16935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		R = Integer.parseInt(temp[2]);
		Arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				Arr[i][j] = Integer.parseInt(temp[j]);
		}
		int[] op = new int[R];
		temp = br.readLine().split(" ");
		for (int i = 0; i < R; i++)
			op[i] = Integer.parseInt(temp[i]);
		br.close();

		for(int i = 0; i < R; i++) {
			switch(op[i]) {
				case 1:	oper1();	break;
				case 2:	oper2();	break;
				case 3:	oper3();	break;
				case 4:	oper4();	break;
				case 5:	oper5();	break;
				case 6:	oper6();	break;
			}
		}

		// output
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(Arr[i][j]).append(" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb.toString());	
	}

	// 상하 반전
	public static void oper1() {
		for (int i = 0; i < N / 2; i++) {
			int[] temp = Arr[i].clone();
			Arr[i] = Arr[N - 1 - i];
			Arr[N - 1 - i] = temp;
		}
	}

	// 좌우 반전
	public static void oper2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = Arr[i][j];
				Arr[i][j] = Arr[i][M - 1 - j];
				Arr[i][M - 1 - j] = temp;
			}
		}
	}

	// 오른쪽 90도 회전
	public static void oper3() {
		int[][] tempArr = new int[M][N];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				tempArr[i][j] = Arr[N - 1 - j][i];
		int temp = N;
		N = M; M = temp;
		Arr = tempArr;
	}

	// 왼쪽 90도 회전
	public static void oper4() {
		int[][] tempArr = new int[M][N];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				tempArr[i][j] = Arr[j][M - 1 - i];
		int temp = N;
		N = M; M = temp;
		Arr = tempArr;
	}

	// 1->2, 2->3, 3->4, 4->1
	public static void oper5() {
		int[][] tempArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				switch(getGroup(i, j)) {
				case 1:
					tempArr[i][j + M/2] = Arr[i][j]; //같은행 뒷칼럼으로
					break;
				case 2:
					tempArr[i + N/2][j] = Arr[i][j]; //같은열 아래행으로
					break;
				case 3:
					tempArr[i][j - M/2] = Arr[i][j]; //같은행 앞컬럼
					break;
				case 4:
					tempArr[i - N/2][j] = Arr[i][j]; //같은열 윗행
					break;
				}
			}
		}
		Arr = tempArr;
	}

	// 1->4, 4->3, 3->2, 2->1
	public static void oper6() {
		int[][] tempArr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				switch(getGroup(i, j)) {
				case 1:
					tempArr[i + N/2][j] = Arr[i][j];
					break;
				case 2:
					tempArr[i][j - M/2] = Arr[i][j];
					break;
				case 3:
					tempArr[i - N/2][j] = Arr[i][j];
					break;
				case 4:
					tempArr[i][j + M/2] = Arr[i][j];
					break;
				}
			}
		}
		Arr = tempArr;
	}
	
	public static int getGroup(int row, int col) {
		if (0 <= row && row < N / 2 && 0 <= col && col < M / 2)
			return 1;
		if (0 <= row && row < N / 2 && M / 2 <= col && col < M)
			return 2;
		if (N / 2 <= row && row < N && M / 2 <= col && col < M)
			return 3;
		if (N / 2 <= row && row < N && 0 <= col && col < M / 2)
			return 4;
		return 0;
	}
}

