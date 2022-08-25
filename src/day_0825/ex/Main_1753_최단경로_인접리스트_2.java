package day_0825.ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1753

public class Main_1753_최단경로_인접리스트_2 {

    static final int INF = Integer.MAX_VALUE;
    static int N,E,start;
    static Map<Integer,List<Node>> map;
    static int[] dist; 


    public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        map = new HashMap<Integer,List<Node>>();
        dist = new int[N + 1];

        for(int i = 1; i <= N; i++){
        	map.put(i, new ArrayList<Node>());
        }
        
        Arrays.fill(dist, INF);

        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < E; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            	map.get(start).add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        // 다익스트라 알고리즘
        dijkstra(start);
        // 출력 부분
        for(int i = 1; i <= N; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(int start){
       PriorityQueue<Node> queue = new PriorityQueue<>();
       boolean[] V = new boolean[N + 1];
       queue.add(new Node(start, 0));  
       dist[start] = 0;

       while(!queue.isEmpty()){
           Node now = queue.poll();
           int to = now.end;

           if(V[to] == true) continue; //이전에 방문 확정된 노드는 돌아 보지 않는다.
           V[to] = true;

           for(Node node : map.get(to)){ //now 와 연뎔된 노드를 모두 확인한다.
               if(dist[node.end] > dist[to] + node.weight){
                   dist[node.end] = dist[to] + node.weight;
                   //연결된 정점으로 가는 비용 dist에 작은 비용 업데이트 
                   queue.add(new Node(node.end, dist[node.end]));
               }
           }
       }
    }
    static class Node implements Comparable<Node>{
    	int end, weight;
    	
    	public Node(int end, int weight){
    		this.end = end;
    		this.weight = weight;
    	}
    	
    	@Override
    	public int compareTo(Node o) {
    		return weight - o.weight;
    	}
    	
    	@Override
    	public String toString() {
    		return "Node [end=" + end + ", weight=" + weight + "]";
    	}
    	
    }
}


/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF

 */