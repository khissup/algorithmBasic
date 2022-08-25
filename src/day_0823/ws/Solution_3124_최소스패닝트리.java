package day_0823.ws;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
// 프림알고리즘에서 간선리스트로 자료구조 만들고 가능은해요 , 인접행렬은 시간,공간 초과 사용하면 X 
// MST  정점의 개수 V(1≤V≤100,000)와 간선의 개수 E(1≤E≤200,000)
public class Solution_3124_최소스패닝트리 { //크루스칼알고리즘 
	static int[] p;

	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();

			p = new int[v + 1];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i <= v; i++) {
				p[i] = i;
			}
			for (int i = 0; i < e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int w = sc.nextInt();
				pq.add(new Node(x, y, w));
			}
			long ans = mst(pq);
			System.out.printf("#%d %d %n",t,ans);
		}

	}

	private static long mst(PriorityQueue<Node> pq) {
		long sum = 0;
		while (!pq.isEmpty()) {
			Node p = pq.poll();
			int x = p.from;
			int y = p.to;
			boolean flag = union(x, y);
			if (flag)
				sum += p.w;
		}
		return sum;
	}

	private static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);

		if (ar != br) {
			p[ar] = br;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (a == p[a])
			return a;
		else {
			int y = find(p[a]);
			p[a] = y;
			return y;
		}
	}
}

class Node implements Comparable<Node> {
	int from;
	int to;
	int w;

	public Node(int x, int y, int w) {
		super();
		this.from = x;
		this.to = y;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.w, o.w);
	}

	@Override
	public String toString() {
		return "Pair [x=" + from + ", y=" + to + ", w=" + w + "]";
	}
	
}

/*
2
7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51
3 3
1 2 1
2 3 2
1 3 3

*/
