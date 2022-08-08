package day_0803.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sumArr = new int[N + 1];
		int sum = 0;
		int temp = 0;
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i < N + 1; i++) {
			temp += Integer.parseInt(st.nextToken());
			sumArr[i] = temp;
		}
		for(int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			sb.append(sumArr[temp2] - sumArr[temp1 - 1]);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
