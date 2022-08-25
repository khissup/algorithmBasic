package day_0824.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb;
	static StringTokenizer st;
	static int M, N;
	static int[][] box;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static List<Pos> tomatoPos;
	static Queue<Pos> queue;
	static int count = 0;
	static int zeroCount = 0;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		count = N * M;
		visit = new boolean[N][M];
		tomatoPos = new ArrayList<>();
		queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] != 0) {
					if(box[i][j] == 1) {
						tomatoPos.add(new Pos(i, j, 0));
					}
				} else {
					zeroCount++;
				}
			}
		}
		for(int i = 0; i < tomatoPos.size(); i++) {
			queue.offer(tomatoPos.get(i));
			visit[tomatoPos.get(i).y][tomatoPos.get(i).x] = true;
			count--;
		}
		sb.append(next());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static int next() {
		int result = 0;
		while(!queue.isEmpty()) {
			Pos temp = queue.poll();
			result = temp.depth;
			for(int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];
				if(ny >= 0 && ny < box.length && nx >= 0 && nx < box[0].length && box[ny][nx] != -1 && visit[ny][nx] == false) {
					visit[ny][nx] = true;
					queue.offer(new Pos(ny, nx, temp.depth + 1));
					count--;
					if(count == 0) {
						return temp.depth;
					}
				}
			}
		}
		return -1;
	}
	static class Pos {
		int y;
		int x;
		int depth;
		public Pos(int y, int x, int depth) {
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
		public Pos() {};
	}
}
