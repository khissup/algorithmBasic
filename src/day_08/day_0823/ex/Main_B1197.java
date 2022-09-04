package day_08.day_0823.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B1197 {
	public static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge> edges = new ArrayList<>();
		int answer = 0;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(start, end, cost));
		}
		//Collections.sort(edges, (a, b) -> a.cost - b.cost);
		edges.sort((a, b) -> a.cost - b.cost);
		
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < E; i++) {
			Edge edge = edges.get(i);
			if(!isSameParent(edge.s, edge.e)) {
				union(edge.s, edge.e);
				answer += edge.cost;
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
	private static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) {
			return true;
		} else {
			return false;
		}
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
		}
	}
}

class Edge {
	int s, e, cost;
	Edge(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}
