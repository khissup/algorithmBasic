package day_0823.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = makeParents(N);
			
					
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(flag == 0) {
					union(from, to);
				} else {
					sb.append(isSameParent(from, to));
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static int[] makeParents(int num) {
		int[] parents = new int[num + 1];
		for(int i = 0; i <= num; i++) {
			parents[i] = i;
		}
		return parents;
	}
	private static int find(int x) {
		if(parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}
	private static int isSameParent(int x, int y) {
		return find(x) == find(y) ? 1 : 0;
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parents[y] = x;
		
	}
}
