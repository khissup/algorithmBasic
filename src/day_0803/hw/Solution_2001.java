package day_0803.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2001 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/input2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = Integer.MIN_VALUE;
			int[] dy = new int[M * M];
			int[] dx = new int[M * M];
			int pos = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < M; j++) {
					dy[pos] = i;
					pos++;
				}
			}
			pos = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < M; j++) {
					dx[pos] = j;
					pos++;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = 0;
					for(int k = 0; k < M * M; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
							sum += map[ny][nx];
						}
					}
					if(sum > result) {
						result = sum;
					}
				}
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(result);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
