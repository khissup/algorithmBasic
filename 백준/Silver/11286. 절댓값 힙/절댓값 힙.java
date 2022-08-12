import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else if(Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else {
					return (int)(o1 - o2);
				}
				
			}
			
		});
		for(int i = 0; i < N; i++) {
			//long temp = Math.abs(Long.parseLong(br.readLine()));
			long temp = Long.parseLong(br.readLine());
			if(temp != 0) {
				priorityQueue.offer(temp);
			} else {
				if(priorityQueue.isEmpty()) {
					sb.append(0);
					sb.append("\n");
				} else {					
					sb.append(priorityQueue.poll());
					sb.append("\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}