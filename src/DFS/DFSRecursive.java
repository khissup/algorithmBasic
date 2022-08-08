package DFS;

public class DFSRecursive {
    public static boolean[] visited = new boolean[9];
    public static int[][] graph = {{},
        {2, 3, 8},
        {1, 7},
        {1, 4, 5},
        {3, 5},
        {3, 4},
        {7},
        {2, 6, 8},
        {1, 7}};
    public static void main(String[] args) {
        int start = 1; // 시작 노드
        dfs(start);
    }
    /*
        DFS 알고리즘을 수행하는 메소드
        @param v 탐색할 노드
     */
    public static void dfs(int v) {
        // 현재 노드 방문 처리
        visited[v] = true;

        // 방문 노드 출력
        System.out.println(v + "");

        // 인접 노드 탐색
        for(int i = 0; i < graph[v].length; i++) {

            // 방문하지 않은 인접 노드 중 가장 작은 노드를 스택에 넣기
            if (visited[i] == false) {
                dfs(i);
            }
        }
    }
}
