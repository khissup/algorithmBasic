package day_0831.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_B15686 {
    static List<int[]> home;
    static List<int[]> chicken;
    static int N, M;
    static int[] arr = new int[2];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if(map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        getMinDistance(0);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        //
    }
    static void getMinDistance(int cnt) {
        if(cnt == 2) {
            int[] hPos = home.get(arr[0]);
            int[] cPos = chicken.get(arr[1]);
            int distance = getDistance(hPos, cPos);
            if(distance < result) {
                result = distance;
            }
            return;
        }
        for(int i = 1; i <= home.size(); i++) {
            if(cnt == 1 && i > chicken.size()) break;
            arr[cnt] = i;
            getMinDistance(cnt + 1);
        }
    }
    static int getDistance(int[] arr1, int[] arr2) {
        return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] = arr2[1]);
    }
}
