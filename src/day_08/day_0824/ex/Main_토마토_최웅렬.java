package day_08.day_0824.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_토마토_최웅렬 {
	static int			w, h;
	static boolean[][]	visited;
	static int[][]		map;
	static int			count = 0;
	static int[]		dx = {1, 0, 0, -1};
	static int[]		dy = {0, -1, 1, 0};
	static Queue<int[]>	que = new LinkedList<>();
	static int			ans = 0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w];
		for (int y = 0; y < h; y++)
		{
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++)
			{
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 0)
					count++;
				if (map[y][x] == 1)
				{
					visited[y][x] = true;
					que.add(new int[] {x, y, 0});
				}
			}
		}
		Bfs();
		sb.append(ans).append('\n');
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void Bfs()
	{
		int[]	temp;
		int		nx = 0;
		int		ny = 0;
		
		while (!que.isEmpty())
		{
			temp = que.poll();
			for (int i = 0; i < 4; i++)
			{
				nx = temp[0] + dx[i];
				ny = temp[1] + dy[i];
				if (nx < 0 || nx >= w || ny < 0 || ny >= h || map[ny][nx] == -1 || visited[ny][nx])
					continue ;
				visited[ny][nx] = true;
				count--;
				que.add(new int[] {nx, ny, temp[2] + 1});
			}
			ans = Math.max(ans, temp[2]);
		}
		if (count != 0)
			ans = -1;
	}
}
