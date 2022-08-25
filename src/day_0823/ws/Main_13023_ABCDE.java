package day_0823.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//출처 : https://www.acmicpc.net/problem/13023 ABCDE

public class Main_13023_ABCDE {
	
	static List<List<Integer>> map;
	static int N,edge,res;
	static int[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		edge= sc.nextInt();
		map = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			map.add(new ArrayList<>());
		}
		for(int i=0;i<edge;i++) {
			int from= sc.nextInt();
			int to= sc.nextInt();
		
			map.get(from).add(to);
			map.get(to).add(from);
		}

		for(int i=0;i<N;i++) {
			used = new int[N];
			used[i] = 1;
			res =  dfs(i,0);
			if(res == 1) break;
		}
		System.out.println(res);
		
	}

	private static int dfs(int now, int depth) {
		if(depth >= 4) {
			return 1;
		}
		
		for(int to=0; to<map.get(now).size() ;to++) {
			if(used[map.get(now).get(to)] != 0) continue;
			
			used[map.get(now).get(to)] = 1;
			if( dfs(map.get(now).get(to),depth+1) == 1) return 1;
			used[map.get(now).get(to)] = 0;
			
		}
		
		return 0;
	}
}
/*

5 4
0 1
1 2
2 3
3 4

0	[1]
1	[0, 2]
2	[1, 3]
3	[2, 4]
4	[3]
5	[]


*/
 
