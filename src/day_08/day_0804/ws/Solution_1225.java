package day_08.day_0804.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> pw = new ArrayDeque<>(); // 배열기반으로 동장
		// Queue<Integer> pw = new LinkedList<>(); // 노드기반으로 동장
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 8; i++) {
				pw.offer(Integer.parseInt(st.nextToken()));
			}
			int pwMakerule = 1;
			while(true) {
				int polledData = pw.poll();
				polledData -= pwMakerule;
				if(pwMakerule >= 5) {
					pwMakerule = 1;
				} else {
					pwMakerule++;
				}
				
				if(polledData <= 0) {
					polledData = 0;
					pw.offer(polledData);
					break;
				} else {
					pw.offer(polledData);
				}
				
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			for(int i = 0; i < 8; i ++) {
				sb.append(pw.poll());
				sb.append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
