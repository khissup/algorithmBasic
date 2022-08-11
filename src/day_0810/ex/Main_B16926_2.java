package day_0810.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B16926_2 {
	static int	rotateX;
	static int	rotateY;
	static int	n, m, r;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int[][]			ans;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		ans = new int[n][m];
		for (int y = 0; y < n; y++)
		{
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++)
			{
				rotateRight(x, y);
				ans[rotateY][rotateX] = Integer.parseInt(st.nextToken());
			}
		}
		for (int y = 0; y < n; y++)
		{
			for (int x = 0; x < m; x++)
			{
				sb.append(ans[y][x]).append(' ');
			}
			sb.deleteCharAt(sb.lastIndexOf(" "));
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void rotateRight(int x, int y)
	{
		int	layer = calLayer(x, y);
		int cycle = 2 * (n - 2 * layer) + 2 * (m - 2 * layer - 2);
		if (cycle == 0)
		{
			rotateX = x;
			rotateY = y;
			return ;
		}
		int rotateRemain = r % cycle;
		int	rotate;
		
		while (rotateRemain != 0)
		{
			if (y == layer && x > layer)
			{
				rotate = Math.min(x - layer, rotateRemain);
				x -= rotate;
				rotateRemain -= rotate;
			}
			else if (x == layer && y < n - 1 - layer)
			{
				rotate = Math.min(n - 1 - layer - y, rotateRemain);
				y += rotate;
				rotateRemain -= rotate;
			}
			else if (y == n - 1 - layer && x < m - 1 - layer)
			{
				rotate = Math.min(m - 1 - layer - x, rotateRemain);
				x += rotate;
				rotateRemain -= rotate;
			}
			else if (x == m - 1 - layer && y > layer)
			{
				rotate = Math.min(y - layer, rotateRemain);
				y -= rotate;
				rotateRemain -= rotate;
			}
		}
		rotateX = x;
		rotateY = y;
	}
	
	public static void rotateLeft(int x, int y)
	{
		int	layer = calLayer(x, y);
		int cycle = 2 * (n - 2 * layer) + 2 * (m - 2 * layer - 2);
		if (cycle == 0)
		{
			rotateX = x;
			rotateY = y;
			return ;
		}
		int rotateRemain = r % cycle;
		int	rotate;
		
		while (rotateRemain != 0)
		{
			if (y == layer && x < m - 1 - layer)
			{
				rotate = Math.min(m - 1 - layer - x, rotateRemain);
				x += rotate;
				rotateRemain -= rotate;
			}
			else if (x == layer && y > layer)
			{
				rotate = Math.min(y - layer, rotateRemain);
				y -= rotate;
				rotateRemain -= rotate;
			}
			else if (y == n - 1 - layer && x > layer)
			{
				rotate = Math.min(x - layer, rotateRemain);
				x -= rotate;
				rotateRemain -= rotate;
			}
			else if (x == m - 1 - layer && y < n - 1 - layer)
			{
				rotate = Math.min(n - 1 - layer - y, rotateRemain);
				y += rotate;
				rotateRemain -= rotate;
			}
		}
		rotateX = x;
		rotateY = y;
	}
	
	public static int calLayer(int x, int y)
	{
		return (Math.min(Math.min(x, y), Math.min(m - x - 1, n - y - 1)));
	}
}
