import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;
	static int V, E;
	static class Node {
		int from, to, weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			long result = 0;
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			makeParents();
			PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> a.weight - b.weight);
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				nodes.offer(new Node(from, to, weight));
			}
			
			while(!nodes.isEmpty()) {
				Node node = nodes.poll();
				int x = node.from;
				int y = node.to;
				if(union(x, y)) {
					result += node.weight;
				}
			}
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY) {
			return false;
		} else {
			parents[rootY] = rootX;
			return true;
		}
	}
	static int find(int v) {
		if(parents[v] == v) {
			return v;
		} else {
			return parents[v] = find(parents[v]);
		}
	}
	static void makeParents() {
		parents = new int[V + 1];
		for(int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}
	}
}