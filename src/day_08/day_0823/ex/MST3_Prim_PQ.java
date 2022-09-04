package day_08.day_0823.ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
//프림 알고리즘 이용 : PriorityQueue 버전
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
 */
/**
 * @author THKim
 */
public class MST3_Prim_PQ{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[N][N];
        boolean[] V = new boolean[N];
        int[] minEdge = new int[N];
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장
        
        int result = 0, nodeCount= 0;
        minEdge[0] = 0;//시작점 비용 0 셋팅
        queue.offer(new Vertex(0,0));
        
		while(!queue.isEmpty()){

			Vertex minVertex = queue.poll();			// PQ 에서 간선비용이 최소인 정점 뽑기
			if(V[minVertex.no]) continue;
			
            result += minVertex.w;   
            V[minVertex.no] = true; 
            if(++nodeCount == N) break; 
            
            for (int to = 0; to < N; to++) { 
                if (!V[to] && input[minVertex.no][to] != 0 &&   minEdge[to] > input[minVertex.no][to] ) {
                	minEdge[to] = input[minVertex.no][to];
                	queue.offer(new Vertex(to, input[minVertex.no][to])); 
                }
            }
        }
        System.out.println(result);
    }
    static class Vertex implements Comparable<Vertex>{
    	int no; 
    	int w;
		public Vertex(int no, int edge) {
			super();
			this.no = no;
			this.w = edge;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
    }
}// end class
