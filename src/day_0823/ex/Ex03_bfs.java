package day_0823.ex;

import java.util.LinkedList;
import java.util.Queue;

// bfs : 최소간선을 탐색 , 가중치가 같을 때 최단거리 ,


public class Ex03_bfs {
    //
	static int[][] map = {
			{0,1,0,0,0},
			{0,1,0,1,0},
			{0,1,0,0,0},
			{0,1,0,1,0},
			{0,0,0,1,0}
	};
	
	static int N;
	static int[][] used;
	
	public static void main(String[] args) {
		N = map.length;
		used = new int[N][N];
		
		//bfs
		Queue<int[]> q = new LinkedList<int[]>();
		
		//
		used[0][0] = 1;
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	
        	int[] dr = {-1,1,0,0};
        	int[] dc = {0,0,-1,1};
        	
        	for(int i=0;i<dr.length ;i++) {
        		int nr = now[0] + dr[i];
        		int nc = now[1] + dc[i];
        		
        		if(nr<0||nc<0||nr>=N || nc>=N) continue;
        		if(map[nr][nc] == 1) continue;
        		if(used[nr][nc] != 0) continue;
        		
        		used[nr][nc] = used[now[0]][now[1]] + 1;
        		q.add(new int[] {nr,nc});
        	}
        }
        
        System.out.println(used[N-1][N-1]-1);
	}

}