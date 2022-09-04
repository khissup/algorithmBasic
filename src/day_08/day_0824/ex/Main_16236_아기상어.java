package day_08.day_0824.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16236
public class Main_16236_아기상어 {

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] arr; // 물고기 정보들이 담길 배열
	static int N; // 배열의 크기
	static int size = 2; // 아기상어의 크기
	static int SRow, SCol; // 아기상어의 위치

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) { // 값이 9면 아기상어의 위치
					SRow = i;
					SCol = j;
					arr[i][j] = 0; // 배열 탐색 시 방해되지 않도록 빈칸으로 만들기
				}
			}
		}
		int time = 0;
		int eatCnt = 0;
		while (true) {
			Fish fish = find(bfs()); // 먹을 수 있는 가장 가까운 물고기 찾기
			if (fish == null)
				break; // 더이상 먹을 물고기가 없으면 끝
			arr[fish.r][fish.c] = 0; // 먹었으니 0으로 없애주기
			SRow = fish.r; // 물고기먹힌곳이 -> 아기 상어의위치
			SCol = fish.c;
			time += fish.distance; // 시간에 거리 더해서 갱신
			// 먹은 수를 늘려주고 먹은 수가 현재 사이즈보다 크거나 같아지면 사이즈를 키우고 먹은 수 초기화
			eatCnt++;
			if (eatCnt >= size) {
				size++;
				eatCnt = 0;
			}

		}
		System.out.println(time);
		in.close();

	}

	static int[][] bfs() { // 아기상어의 위치로부터의 거리 정보 배열을 반환
		int[][] distance = new int[N][N]; // 아기상어와 물고기들간 거리 정보가 담길 배열
		// 거리를 전부 -1로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], -1);
		}
		Queue<int[]> q = new ArrayDeque<int[]>();
		distance[SRow][SCol] = 0; // used 배열 ,현재 위치 거리를 0으로 초기화,아기상어가있는곳 0
		q.offer(new int[] { SRow, SCol }); // 큐에 현재 위치 좌표 넣기 , 아기상어위치가 탐색 시작 위치
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < dr.length; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (arr[nr][nc] <= size && distance[nr][nc] == -1) { // 더 큰 물고기는 못 지나감, 방문했던 곳은 다시방문 x
					distance[nr][nc] = distance[now[0]][now[1]] + 1; // used , 방문한 곳의 거리 증가
					q.offer(new int[] { nr, nc });
				}
			}
		}
		return distance;
	}

	// 위쪽->아래, 왼쪽->오른쪽으로 거리 배열을 찾으면서 먹을 수 있는 물고기 찾아서 반환
	static Fish find(int[][] distance) {
		int minDistance = Integer.MAX_VALUE;
		Fish fish = null;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (distance[i][j] != -1 && 1 <= arr[i][j] && arr[i][j] < size && distance[i][j] < minDistance) {
					// distance[i][j] <= minDistance 이 아닌 < 인 이유는 위쪽, 왼쪽 우선순위 때문
					minDistance = distance[i][j];
					fish = new Fish(i, j, minDistance);
				}
			}
		}
		return fish;
	}
	static class Fish { // 잡아먹을 물고기 객체
		int r, c, distance; // 물고기의 위치 좌표, 아기상어로부터의 거리

		public Fish(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", distance=" + distance + "]";
		}

	}
}
/*
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

14
*/