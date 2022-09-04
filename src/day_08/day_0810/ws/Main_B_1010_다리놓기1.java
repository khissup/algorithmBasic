package day_08.day_0810.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_B_1010_다리놓기1  {

	static int N,M,memo[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			memo = new int[M+1][N+1];
			System.out.println(combination(M,N));  //M개중 N개 뽑기 
		}
	}
	private static int combination(int n,int r) {
		if(memo[n][r]!=0) return memo[n][r];
		if(n==r || r==0) return 1;
		if(n<r) return 0;
		return memo[n][r]=combination(n-1, r-1) + combination(n-1, r);
	}
}
