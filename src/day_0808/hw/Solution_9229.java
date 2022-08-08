package day_0808.hw;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_9229 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input9229.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snack = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                snack[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = N - 1; j >= 0; j--) {
                for (int k = N - 1; k >= 0; k--) {
                    if(j == k) {
                        continue;
                    }
                    if(snack[j] + snack[k] > sum && snack[j] + snack[k] <= M) {
                        sum = snack[j] + snack[k];
                    }
                }
            }
            if (sum == 0) {
                sum = -1;
            }
            String result = String.format("#%d %d\n", i, sum);
            sb.append(result);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
