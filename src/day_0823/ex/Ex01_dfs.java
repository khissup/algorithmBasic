package day_0823.ex;

import java.util.Scanner;
import java.util.Stack;

public class Ex01_dfs {
	static int[][] map;
	static int N, edge, mincost = 999999, maxcost = -1, sum;
	static int[] used; // 방문 여부
	static Stack<Integer> path = new Stack<Integer>(); // 경로 기록
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		edge = sc.nextInt();
		map = new int[N + 1][N + 1];
		used = new int[N + 1];
		for(int i = 0; i < edge; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			map[from][to] = cost;
			// 만약 무방향일경우 map[to][from] = cost; 추가하면 됨
		}
		used[0] = 1;
		path.push(0);
		dfs(0);
		System.out.println(mincost);
		System.out.println(maxcost);
	}
	private static void dfs(int now) {
		if(now == 3) {
			System.out.println(path + "=>");
			System.out.println(sum);
			mincost = Math.min(mincost, sum);
			maxcost = Math.max(maxcost, sum);
		}
		
		for(int to = 0; to < N; to++) { // now에서 갈 수 있는 노드를 찾아야함
			if(used[to] != 0) continue; // 이미 방문했다면 그냥 지나감
			if(map[now][to] == 0) continue;
			used[to] = 1;
			path.push(to);
			sum += map[now][to];
			dfs(to);
			
			used[to] = 0;
			path.pop();
			sum -= map[now][to];
		}
	}
}

/*
BFS는 모든경로를 뽑아내지는 못함. 
DFS가 모든경로를 뽑아내므로 DFS를 이용할때도 있음
(5 == 비용, 코스트)
정점, 간선, 비용
4 6
0 1 5
0 2 3
0 3 30
2 3 20
1 3 15
2 1 1

0 -> 3 으로 갈 수 있는 경로
최대비용, 최소비용

*/