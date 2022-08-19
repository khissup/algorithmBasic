import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, S;
	static boolean[] V;
	static List<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input/1260.txt"));

		Scanner sc = new Scanner(System.in);
		N =  sc.nextInt();
		M =  sc.nextInt();
		S =  sc.nextInt();
		
		V = new boolean[N+1];
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}

		int from,to;
		for(int i=0;i<M;i++) { // 간선 M개 들어옴
			from =  sc.nextInt();
			to =  sc.nextInt();
			
			list.get(from).add(to);
			list.get(to).add(from);
		}		
		for(int i=0;i<=N;i++) {
			Collections.sort(list.get(i));
		}
		
		V[S] = true;
		dfs(S);
		System.out.println();
		Arrays.fill(V, false);
		bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
				// Queue<Integer> queue = new ArrayDeque<Integer>();
		V[S] = true;
		queue.offer(S);
		
		int now;
		while(!queue.isEmpty()) {
			now =  queue.poll();
			System.out.print(now+" ");
			for( int to :list.get(now)) {
				if(V[to]) continue;
				V[to] = true;
				queue.offer(to);
			}
		}
		
	}

	private static void dfs(int now) {
		System.out.print(now+" ");
		
		for( int to :list.get(now)) {
			if(V[to]) continue;
			V[to] = true;
			dfs(to);
		}
		
	}
	
	
	
	
}
		// 만약 작은값부터 정렬이 안되있을경우
//		for(int i = 0; i <= N; i++) {
//			Collections.sort(list.get(i));
//		}
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
*/