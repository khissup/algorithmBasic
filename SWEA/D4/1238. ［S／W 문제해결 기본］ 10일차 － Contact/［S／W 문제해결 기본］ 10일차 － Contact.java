
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][] adjMatrix;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());// 입력받는 데이터의길이
            start = Integer.parseInt(st.nextToken()); //

            // 인접행렬
            adjMatrix = new boolean[101][101]; // 1 based index
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = true;	// 연결시켜주기
            }
            int ans = bfs();
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }

    // 마지막 레벨에 있는 노드들 중 최대값 구하기
    static int bfs() {
        int ans = 0;

        boolean[] visited = new boolean[101];	//방문배열
        int size = 0;	// 큐 크기 

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);	// 시작점
        visited[start] = true;

        while (!q.isEmpty()) {
            size = q.size();
            int maxNode = 0;
            // 같은 레벨에 대한 노드들 구분하기
            while (--size >= 0) {
                int curr = q.poll();
                for(int i=1;i<=100;i++) {
                    if(adjMatrix[curr][i]&&!visited[i]) {
                        q.offer(i);
                        if(maxNode<i) maxNode = i;	// 최대 노드번호 저장
                        visited[i] = true;	// 방문 처리
                    }
                }
            }
            if(maxNode>0)
                ans = maxNode;	//레벨별 최대 노드번호 갱신
        }
        return ans;
    }
}