import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        sb.append("<");
        while(true) {
            for(int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()) {
                sb.append(", ");
            } else {
                break;
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}