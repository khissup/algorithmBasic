package day_08.day_0823.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7465 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = makeSet(N);
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(union(x, y)) {
					N--;
				}
			}
			sb.append(N).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static int find(int x) {
		if(parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}
	private static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY) {
			return false;
		} else {
			parents[rootY] = rootX;
			return true;
		}
	}
	private static int[] makeSet(int N) {
		int[] parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		return parents;
	}
	public static void make(int n) {
		for(int i = 1 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
}
