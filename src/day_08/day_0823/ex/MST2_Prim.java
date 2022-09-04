package day_08.day_0823.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class MST2_Prim { //정점(노드) 중심 

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[N][N];
        
        int[] minEdge = new int[N];
        boolean[] V = new boolean[N];//정점이 신장트리에 포함 여부 
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장

        int minVertex,min,result = 0;
        minEdge[0] = 0; // 임의의 시작점 비용 0 셋팅
		
        for(int c = 0 ; c< N; c++){// 모든 정점 수만큼 반복
        	 min = Integer.MAX_VALUE;// 초기값으로 정수의 최대치를 주고 시작
             minVertex = 0;
             
             for(int i=0; i<N; ++i) { 
             	if(!V[i] &&  min > minEdge[i] ) {
             		min = minEdge[i];
             		minVertex = i;
             	}
             }	
             result += min; 
             V[minVertex] = true;  //선택된 정점응 신장트리에 포함 
             
             for (int i = 0; i < N; i++) { //선택된 정점 기준으로 신장 트리에 포함 되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신 
                 if (!V[i] && input[minVertex][i] != 0 &&  minEdge[i] > input[minVertex][i]  ) {
                 	                      //인접체크     
                 	minEdge[i] = input[minVertex][i];
                 }
             }
		}
        System.out.println(result);
	}

}


/*

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

*/