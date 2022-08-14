package day_0814.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B15649 {//
    static boolean[] isSelected;
    static int[] numbers;
    static int N, M;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N + 1];
        numbers = new int[M + 1];
        permutation(0);
    }

    private static void permutation(int cnt) {
        if(cnt == N) {
            for(int i = 0; i < M; i++) {
                sb.append(numbers[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                numbers[cnt] = i;
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}
