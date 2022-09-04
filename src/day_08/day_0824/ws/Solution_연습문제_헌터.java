package day_08.day_0824.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 0435
public class Solution_연습문제_헌터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			List<Pos> quest = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						quest.add(new Pos(i, j, map[i][j]));
					}
				}
			}
		}
	}
	static class Game {
		static Pos hunterPos;
		static int[][] map;
		static int result;
		static boolean[] isSelected;
		static List<Pos> queue;
		static int[] order;
//		static Queue<Pos> queue;
//		static int[] dy = {-1, 1, 0, 0};
//		static int[] dx = {0, 0, 1, -1};
		
		
		
		public Game(int[][] map, List<Pos> queue) {
			this.map = map;
			this.queue = queue;
			// 방문순서
			order = new int[queue.size() / 2];
			hunterPos = new Pos(0, 0, 0);
			result = 0;
//			queue = new LinkedList<>();
//			queue.offer(hunterPos);
//			visit = new boolean[map.length][map[0].length];
//			visit[0][0] = true;
		}
		
		private static void makeOrder(int cnt) {
			if(cnt == order.length) {
				for(int i = 0; i < order.length; i++) {
					
				}
				return;
			}
			
			for(int i = 1; i < order.length; i++) {
				if(isSelected[i]) continue;
				order[cnt] = i;
				isSelected[i] = true;
				makeOrder(cnt + 1);
				isSelected[i] = false;
			}
		}
		
		static int distance(Pos a, Pos b) {
			return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); 
		}

//		static int bfs() {
//			int target = Integer.MAX_VALUE;
//			while(!queue.isEmpty()) {
//				Pos temp = queue.poll();
//				for(int i = 0; i < 4; i++) {
//					int ny = temp.y + dy[i];
//					int nx = temp.x + dx[i];
//					if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length && visit[ny][nx] == false) {
//						if(map[ny][nx] != 0) {
//							target = map[ny][nx];
//							map[ny][nx] = 0;
//						}
//						visit[ny][nx] = true;
//						queue.offer(new Pos(ny, nx, temp.customer + 1));
//					}
//				}
//			}
//			return 0;
//		}
	}
	
	static class Pos {
		int y;
		int x;
		int customer;
		public Pos(int y, int x, int customer) {
			this.y = y;
			this.x = x;
			this.customer = customer;
		}
	}
}
