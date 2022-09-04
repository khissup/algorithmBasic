package day_08.day_0810.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1010   다리놓기
//점화식 도출 방법   조합에서 점화식 도출 하는 문제에요

public class Main_B_1010_다리놓기 { 

	static int N = 0;
	static int Num = 0;
	static int[][] dp = new int[30][30]; // 최대입력 29

	public static void main(String[] args) throws Exception, IOException {
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;

		}
		// 이항계수
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

			}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			

			System.out.println(dp[M][N]); //mCn
		}
	}
}

