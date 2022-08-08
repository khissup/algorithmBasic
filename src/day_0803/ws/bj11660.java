package day_0803.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		StringBuilder	sb = new StringBuilder();
		int 			n = Integer.parseInt(st.nextToken());
		int				m = Integer.parseInt(st.nextToken());
		int[][]			arr = new int[n + 1][n + 1];
		int				x1, y1, x2, y2;
		
		for (int y = 1; y <= n; y++)			
		{
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= n; x++)
				arr[y][x] = Integer.parseInt(st.nextToken()) + arr[y][x - 1] + arr[y - 1][x] - arr[y - 1][x - 1];
		}
		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
