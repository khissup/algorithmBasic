package DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B1260_DFS_BFS {
    public static int[][] branch;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static int N;
    public static int M;
    public static int V;

    public static void dfs(int start) {
        visit[start] = true;
        System.out.println(start + " ");
        for (int i = 1; i <= N; i++) {
            if(branch[start][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;
        System.out.println(start + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i = 1; i < branch.length; i++) {
                if (branch[temp][i] == 1 && visit[i] == false) {
                    queue.add(i);
                    visit[i] = true;
                    System.out.println(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        V = in.nextInt();

        branch = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            // 인접행렬 생성
            branch[a][b] = branch[b][a] = 1;
        }

        // 정점은 1로부터 DFS 시작
        dfs(V);
        System.out.println();

        // DFS 완료 후 visit list 초기화
        Arrays.fill(visit, false);

        // 정점은 1로부터 DFS 시작
        bfs(V);
    }
}

/*

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
V부터 방문된 점을 순서대로 출력하면 된다.

input1
4 5 1
1 2
1 3
1 4
2 4
3 4

output1
1 2 4 3
1 2 3 4

input2
5 5 3
5 4
5 2
1 2
3 4
3 1

output2
3 1 2 5 4
3 1 4 2 5

input3
1000 1 1000
999 1000

output3
1000 999
1000 999
 */