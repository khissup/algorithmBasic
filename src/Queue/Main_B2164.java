package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_B2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            cards.offer(i);
        }
        boolean flag = true;
        while (cards.size() > 1) {
            if(flag) {
                cards.poll();
                flag = false;
            } else {
                cards.offer(cards.poll());
                flag = true;
            }
        }
        sb.append(cards.poll());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}