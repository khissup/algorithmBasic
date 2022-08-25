package day_0824.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_B10026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        char target = map[0][0];
        boolean[][] visit = new boolean[map.length][map[0].length];
        visit[0][0] = true;
        Queue<char[]> queue = new ArrayDeque<>();
        queue.offer(new char[]{0, 0});
        while (!queue.isEmpty()) {
            char[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length && visit[ny][nx] == false) {

                }
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                sb.append(map[i][j]).append(" ");
//            }
//            sb.append("\n");
//        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
