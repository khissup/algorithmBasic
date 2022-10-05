import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int lastCheese = 0;
    static int time = 0;
    static int result = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    lastCheese++;
                }
            }
        }
        while (lastCheese != 0) {
            result = lastCheese;
            time++;
            bfs();
        }
        sb.append(time).append("\n").append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static private void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;
        map[0][0] = 2;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i ++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny >= 0 && ny < R && nx >= 0 && nx < C && !visit[ny][nx]) {
                    if(map[ny][nx] == 0 || map[ny][nx] == 2) {
                        queue.offer(new int[]{ny, nx});
                    }
                    if(map[ny][nx] == 1) {
                        lastCheese--;
                    }
                    visit[ny][nx] = true;
                    map[ny][nx] = 2;
                }
            }
        }
        visit = new boolean[R][C];
    }
}