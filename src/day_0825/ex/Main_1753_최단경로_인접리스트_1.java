package day_0825.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1753

public class Main_1753_최단경로_인접리스트_1 {

    static final int INF = Integer.MAX_VALUE;
    static int N,E,start;
    static List<Node>[] list;
    static int[] dist; //최단 경로 트리 


    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            // start에서 end로 가는 weight 가중치
            list[from].add(new Node(to, weight));
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
       dist[start] = 0;//start 까지의 비용은 0
       queue.add(new Node(start, 0));  

       while(!queue.isEmpty()){
           Node now = queue.poll();
           int to = now.end;

           if(V[to] == true) continue; //이전에 방문 확정된 노드는 돌아 보지 않는다.
           V[to] = true;

           for(Node node : list[to]){ //cur 와 연결된 노드를 모두 확인한다.
               if(dist[node.end] > dist[to] + node.weight){
                   dist[node.end] = dist[to] + node.weight; 
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