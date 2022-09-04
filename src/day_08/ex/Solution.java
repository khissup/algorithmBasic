package day_08.ex;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int totalCnt;
    static int N;
    static int max;
    static int min;
    static int map[][];

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static ArrayList<int[]> list;  //고려해야하는 코어 리스트 정보
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if((i == 0 || j == 0 || i == N-1 || j == N-1) && map[i][j] == 1) {
                        continue;
                    }
                    if(map[i][j] == 1) {
                        list.add(new int[] {i, j});
                        totalCnt++;
                    }
                }
            }
            perm(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    //부분집합에 포합된 코어index
    private static void perm(int index,int coreCount) {

        if(totalCnt - index + coreCount < max) {
            return;
        }

        if(index == totalCnt) {
            int res = getLength();
            if(max < coreCount) {
                max = coreCount;
                min = res;
            } else if(max == coreCount) {
                if(min > res) min = res;
            }
            return;
        }
        int[] cur = list.get(index);
        int y = cur[0];
        int x = cur[1];
        for (int direction = 0; direction < 4; direction++) {
            // 전원 연결
            if(isAvailable(y, x, direction)) {
                setting(y, x, direction, 2);

                // 다음코어 재귀돌림
                perm(index + 1,coreCount + 1);

                setting(y, x, direction,0);
            }
        }
        perm(index + 1,coreCount); // 해당 코어를 전원에 연결하지 않고 다음 코어로 넘어감
    }
    private static boolean isAvailable(int y,int x ,int direction) { //이위치(코어의 위치)에서 이 d방향으로 끝까지 갈수 있는지 check
        int ny = y;
        int nx = x;
        while(true) {
            ny += dy[direction];
            nx += dx[direction];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) {
                break;
            }
            // 연결불가
            if(map[ny][nx] >= 1) {
                return false;
            }
        }
        return true;
    }


    // 재귀에서 dy, dx돌아감

    private static void setting(int y, int x, int direction, int s) {
        int ny = y;
        int nx = x;
        while(true) {
            ny += dy[direction];
            nx += dx[direction];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) {
                break;
            }
            map[ny][nx] = s;
        }
    }

    //　길이 구하기
    private static int getLength() {
        int length = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 2) ++length;
            }
        }
        return length;
    }
}