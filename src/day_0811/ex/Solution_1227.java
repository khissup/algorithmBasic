package day_0811.ex;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1227 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] visit = new boolean[100][100];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input1227.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int result = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            int[][] position = new int[2][2]; // 시작, 끝좌표
            for (int i = 0; i < 100; i++) {
                char[] mapValue = br.readLine().toCharArray();
                for (int j = 0; j < 100; j++) {
                    if(mapValue[j] == '2') {
                        position[0][0] = i;
                        position[0][1] = j;
                    } else if (mapValue[j] == '3') {
                        position[1][0] = i;
                        position[1][1] = j;
                    }
                    map[i][j] = mapValue[j] - '0';
                }
            }
            result = isPossible(map, position);
            sb.append("#");
            sb.append(N);
            sb.append(" ");
            sb.append(result);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int isPossible(int[][] map, int[][] position) {
        for(int i = 0; i < 4; i++) {
            int ny = position[0][0] + dy[i];
            int nx = position[0][1] + dx[i];
            if(ny >= 0 && ny < map.length && nx >= 0 && nx < map.length && visit[ny][nx] == false && map[ny][nx] == 0) {
                position[0][0] = ny;
                position[0][1] = nx;
                visit[ny][nx] = true;
                if(map[ny][nx] == 3) {
                    return 1;
                } else {
                    isPossible(map, position);
                }
            }
        }
        return 0;
    }
}
