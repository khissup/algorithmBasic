import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int currentValue = Integer.parseInt(st.nextToken());
			// i = 3, val = 5
			while(!stack.empty()) {
				if (stack.peek()[1] > currentValue) {
					sb.append(stack.peek()[0]);
					sb.append(" ");
					break;
				} else {
					stack.pop();
				}
			}
			if (stack.empty()) {
				sb.append("0 ");
			}
			stack.push(new int[]{i, currentValue});
			// [2, 9]
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}