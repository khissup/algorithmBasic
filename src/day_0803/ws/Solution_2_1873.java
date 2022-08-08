package day_0803.ws;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2_1873
{
static int      w = 0;
static int      h = 0;
static char[][] map;

public static void main(String[] args) throws Exception
{
    BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder   sb = new StringBuilder();
    StringTokenizer st;
    int             testCase = Integer.parseInt(br.readLine());
    Tank            tank = null;
    int             order;
    String          task;

    for (int i = 1; i <= testCase; i++)
    {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        for (int cy = 0; cy < h; cy++)
        {
            map[cy] = br.readLine().toCharArray();
            for (int cx = 0; cx < w; cx++)
            {
                if ("<>^v".contains(map[cy][cx] + ""))
                {
                    tank = new Tank(cx, cy, w, h, map[cy][cx], map);
                }
            }
        }
        order = Integer.parseInt(br.readLine());
        task = br.readLine();
        for (int j = 0; j < order; j++)
        {
            if (task.charAt(j) == 'S')
                tank.shoot();
            else
                tank.move(task.charAt(j));
        }
        map = tank.getMap();
        sb.append('#');
        sb.append(i);
        sb.append(' ');
        for (int cy = 0; cy < h; cy++)
        {
            sb.append(String.valueOf(map[cy]));
            sb.append('\n');
        }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
	}
}

class Tank
{
	static int[]    dx = {-1, 0, 1, 0};
	static int[]    dy = {0, -1, 0, 1};
	static char[]   arr = {'<', '^', '>', 'v'};
	static char[][] map;
	int tankX;
	int tankY;
	int w;
	int h;
	int direc;

	public Tank()
	{
	
	}
	
	public Tank(int x, int y, int w, int h, char direc, char[][] map)
	{
	    tankX = x;
	    tankY = y;
	    this.w = w;
	    this.h = h;
	    if (direc == '<')
	        this.direc = 0;
	    else if (direc == '^')
	        this.direc = 1;
	    else if (direc == '>')
	        this.direc = 2;
	    else if (direc == 'v')
	        this.direc = 3;
	    this.map = map;
	    this.map[y][x] = '.';
	}

	public void move(char move)
	{
	    int nx;
	    int ny;
	
	    if (move == 'L')
	        this.direc = 0;
	    else if (move == 'U')
	        this.direc = 1;
	    else if (move == 'R')
	        this.direc = 2;
	    else if (move == 'D')
	        this.direc = 3;
	    nx = tankX + dx[direc];
	    ny = tankY + dy[direc];
	    if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == '.')
	    {
	        tankX = nx;
	        tankY = ny;
	    }
	}
	
	public void shoot()
	{
	    int i = 1;
	    int nx;
	    int ny;
	
	    while (true)
	    {
	        nx = tankX + dx[direc] * i;
	        ny = tankY + dy[direc] * i;
	        if (nx >= 0 && nx < w && ny >= 0 && ny < h)
	        {
	            if (map[ny][nx] == '#')
	                break ;
	            else if (map[ny][nx] == '*')
	            {
	                map[ny][nx] = '.';
	                break ;
	            }
	        }
	        else
	            break ;
	        i++;
	    }
	}
	
	public char[][] getMap()
	{
	    map[tankY][tankX] = arr[direc]; 
	    return (map);
	}
}
