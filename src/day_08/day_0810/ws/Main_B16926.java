package day_08.day_0810.ws;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B16926 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input16926.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //result = turnReverse(arr);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void turnReverse(int[][] arr, int[][] result, int ni, int nj) {
        if(ni > arr.length && nj > arr[ni].length) {
            return;
        }

    }
    public static int[][] turnReverse90(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                result[i][arr[i].length - 1 - j] = arr[j][i];
            }
        }
        return result;
    }
}
