package day_0819.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234 {
	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			int[] chu = new int[N];
			int[] leftChu = new int[N];
			int[] rightChu = new int[N];
			isSelected = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	public static void perm(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			
			return;
		}
		
		// 가능한 모든 수 시도 
		for (int i = 1; i <= N; i++) {
			// 중복체크 필요!
			if(isSelected[i]) continue;
			// 해당 수 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			// 다음 주사위던지러 가기
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
