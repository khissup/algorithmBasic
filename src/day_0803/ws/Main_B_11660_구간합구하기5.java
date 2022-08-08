package day_0803.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B_11660_구간합구하기5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		int[][] sumArr = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				sumArr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + arr[i][j];
			}
		}
		
		for(int i = 1; i < M + 1; i++) {
			int sum = 0;
			int[] pos = new int[4];
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				pos[j] = Integer.parseInt(st.nextToken());
			}
			sum = sumArr[pos[2] - 1][pos[3]] + sumArr[pos[2]][pos[3] - 1] -
					sumArr[pos[0] - 1][pos[3]] - sumArr[pos[2]][pos[1] - 1] + sumArr[pos[0] - 1][pos[1] - 1];
			sb.append(sum);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
