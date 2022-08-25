package day_0824.ex;

import java.io.*;
import java.util.*;

public class p3055_고태진 {
	static int R, C, ans = -1;
	static char[][] map;
	static int[][] dp;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<int[]> queue;
	static int[] start;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String input = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'S') {
					start = new int[] { i, j, 0 }; // 고슴도치
				} else if (map[i][j] == '*') {
					queue.add(new int[] { i, j, 1 }); // 물
				}
			}
		}

		queue.add(start);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (map[cur[0]][cur[1]] == 'D') {
				ans = dp[cur[0]][cur[1]];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
					if (cur[2] == 1) { // 물
						if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
							map[ny][nx] = '*';
							queue.add(new int[] { ny, nx, 1 });
						}
					} else { // 고슴도치
						if (map[ny][nx] == '.' || map[ny][nx] == 'D') {
							if (dp[ny][nx] == 0) {
								dp[ny][nx] = dp[cur[0]][cur[1]] + 1;
								queue.add(new int[] { ny, nx, 0 });
							}
						}
					}
				}
			}
		}

		if (ans == -1) {
			bw.write("KAKTUS\n");
		} else {
			bw.write(ans + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
