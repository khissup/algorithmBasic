package day_0829.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[] arr = new int[2];
    static int[][] map;
    static boolean[] visited = new boolean[2];
    static List<Pos> chargeList = new ArrayList<>();
    static List<Pos> choosenList = new ArrayList<>();
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            map = new int[31][31];
            choosenList.add(new Pos(0, 0));
            choosenList.add(new Pos(0, 0));

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) + 15;
                int y = Integer.parseInt(st.nextToken()) + 15;
                int d = Integer.parseInt(st.nextToken());
                map[x][y] = d;
            }

            permitation(0);
            visited = new boolean[2];
            arr = new int[2];
            getAvailable2(0, 0);
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    private static void getAvailable(int cnt) {
        if(cnt == 2) {
            sb.append(choosenList.get(0)).append(" ").append(choosenList.get(1)).append("\n");
            return;
        }
        for(int i = 0; i < chargeList.size(); i++) {
            if(!visited[cnt]) {
                choosenList.set(cnt, chargeList.get(i));
                visited[cnt] = true;
                getAvailable(cnt + 1);
                visited[cnt] = false;
            }
        }
    }

    private static void getAvailable2(int cnt, int start) {
        if(cnt == 2) {
            sb.append(chargeList.get(arr[0])).append(" ").append(chargeList.get(arr[1])).append("\n");
            return;
        }
        for(int i = start; i < chargeList.size(); i++) {
            if(!visited[cnt]) {
                arr[cnt] = i;
                visited[cnt] = true;
                getAvailable2(cnt + 1, start + 1);
                visited[cnt] = false;
            }
        }
    }

    private static void permitation(int cnt) {
        if(cnt == 2) {
            if(map[arr[0]][arr[1]] == 0) {
                chargeList.add(new Pos(arr[0], arr[1]));
//                sb.append(Arrays.toString(arr)).append("\n");
            }
            return;
        }
        for(int i = 0; i < 31; i++) {
            if(!visited[cnt]) {
                arr[cnt] = i;
                visited[cnt] = true;
                permitation(cnt + 1);
                visited[cnt] = false;
            }
        }
    }
//    private static List<Pos> makePos(List<Home> homeList) {
//        List<Pos> list = new ArrayList<>();
//        for(int i = 0; i < 31; i++) {
//            for(int j = 0; j < 31; j++) {
//                for(int k = 0; k < list.size(); k++) {
//                    int x = homeList.get(k).x;
//                    int y = homeList.get(k).y;
//                    if(i - 15 == x && j - 15 == y) {
//                        continue;
//                    }
//                }
//            }
//        }
//    }

    static class Home {
        int x;
        int y;
        int distance;
        public Home(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
