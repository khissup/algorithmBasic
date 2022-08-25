package day_0824.ex;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem_16236_문한규 {
	static class list implements Comparable<list>
	{
		public int x;
		public int y;
		public int cnt;
		public list(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(list temp)
		{
			if(this.cnt == temp.cnt)
			{
				if(this.x<temp.x)
					return -1;
				else if(this.x==temp.x)
				{
					if(this.y<temp.y)
						return -1;
					else return 1;
				}
				else 
					return 1;
			}
			else if(this.cnt>temp.cnt)
				return 1;
			else
				return -1;
		}
	}
	static int N;
	static int[][] map ;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue <list> que = new LinkedList<>();
	static boolean [][]visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				map[i][j]=sc.nextInt();
				if(map[i][j]==9)
				{
					que.add(new list(i,j,0));
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		BFS();
	}
	static void BFS()
	{
		int sz = 2;
		int eat = 0;
		int cnt=0;
		while(true)
		{
			PriorityQueue<list> fish = new PriorityQueue<list>();
			while(!que.isEmpty()) // 먹이 다 찾을동안 이동하고
			{
				list temp = que.poll(); // que.front 팝 해오기
				//visit[temp.x][temp.y] = true;
				for(int i=0;i<4;i++)
				{
					int nx = dx[i]+temp.x;
					int ny = dy[i]+temp.y;
					if( nx>=0 && ny>=0 && nx<N && ny<N && visit[nx][ny]==false )
					{
						if(map[nx][ny]<=sz)
						{
							if(map[nx][ny]<sz && map[nx][ny]!=0)
							{
								fish.add(new list(nx,ny,temp.cnt+1));
							}
							que.add(new list(nx,ny,temp.cnt+1));
							visit[nx][ny] = true;
						}
					}
				}
			}
			for(int i=0;i<N;i++) // 방문배열 초기화 작업
			{
				for(int j=0;j<N;j++)
					visit[i][j] = false;
			}
			if(!fish.isEmpty()) // 먹이 먹은곳에서 다시 출발하고 , 없으면 컷
			{
				list temp = fish.poll();
				map[temp.x][temp.y]=0;
				visit[temp.x][temp.y]=true;
				eat++;
				cnt = temp.cnt;
				que.add(temp);
			}
			else
			{
				System.out.println(cnt);
				return;
			}
			if(eat==sz)
			{
				sz++;
				eat=0;
			}
		}
		
	}
	
}
