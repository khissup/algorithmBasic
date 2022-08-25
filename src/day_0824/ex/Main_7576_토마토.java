package day_0824.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/7576
public class Main_7576_토마토 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int res , zeroCount;
	
	public static void main(String[] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

		
		int[][] Arr = new int[N][M];
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				Arr[i][j] = Integer.parseInt(st.nextToken());
				if(Arr[i][j]==0) zeroCount++;
				if(Arr[i][j]==1)
					queue.add(new Point(i,j,0)); //익은 토마토위치 bfs 시작위치 
			}
		}
		
		while( !queue.isEmpty()) {
        	if(zeroCount == 0) break;
			Point now = queue.poll();
			int depth = now.depth;
			for(int i = 0; i<4; i++) {
				int nr = now.r+dr[i];
				int nc = now.c+dc[i];
				if( nr < 0 || nc < 0 || nr >= Arr.length || nc >= Arr[nr].length ) continue;
				if( Arr[nr][nc] == 0 ) {
					Arr[nr][nc] = depth+1;
					res = depth+1;
					zeroCount--;
					queue.add(new Point(nr,nc,depth+1));
				}
			}
		}
		System.out.println(zeroCount>0?-1:res);
	}
	static class Point{
		int r; 
		int c;
		int depth;
		Point(int r, int c,int depth){
			this.r=r;
			this.c=c;
			this.depth = depth;
		}
	}
}

/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

//Scanner랑 속도 차이 많이나요    2 ≤ M,N ≤ 1,000
*/