package day_0831.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B15649 {
    static int N, M;
    static StringBuilder sb;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        arr = new int[M + 1];
        perm(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static void perm(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[cnt] = i;
                perm(cnt + 1);
                visit[i] = false;
            }
        }
    }
}
