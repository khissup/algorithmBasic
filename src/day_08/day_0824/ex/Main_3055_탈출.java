package day_08.day_0824.ex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/3055
public class Main_3055_탈출 {
	
    static int R, C;
    static Character[][] map;
    static Queue<int[]> q = new LinkedList<>();;
    static Queue<int[]> water = new LinkedList<>();;
    static int res=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                switch (map[i][j]) {
					case 'S': q.add(new int[]{i, j,0});	break;
					case '*': water.add(new int[]{i,j}); break;
				}
            }
        }

        bfs();
        System.out.println(res==Integer.MAX_VALUE?"KAKTUS":res);
    }

    static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
    public static void bfs() {

        while (!q.isEmpty()) {
            // 물 퍼뜨림
            int len = water.size();
            for(int i=0;i<len;i++){
                int[] data = water.poll();
                
                for (int k = 0; k < 4; k++) {
                    int nr = data[0] + dr[k];
                    int nc = data[1] + dc[k];
                    
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc]=='.') {
                        map[nr][nc] = '*';
                        water.add(new int[]{nr,nc});
                    }
                }
            }

            // 고슴도치 이동
            len = q.size();
            for(int i=0;i<len;i++){
                int[] now = q.poll();
                for (int k = 0; k < 4; k++) {
                	int nr = now[0] + dr[k];
                    int nc = now[1] + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if(map[nr][nc]=='D'){
                            res=Math.min(res,now[2]+1);
                            return;
                        }else if(map[nr][nc]=='.'){
//                            map[now[0]][now[1]] = '.'; //??
                            map[nr][nc] = 'S';
                            q.add(new int[]{nr,nc,now[2]+1});
                        }
                    }
                }
            }
        }
    }
}
/*

3 6
D...*.
.X.X..
....S.

6
KAKTUS

5 4
.D.*
....
..X.
S.*.
....

4

비어있는 곳은 '.'
물이 차있는 지역은 '*'
돌은 'X'
비버의 굴은 'D
고슴도치의 위치는 'S'

물도 매 분마다 비어있는 칸으로 확장
고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다
S->D

1) 물이 확장하는 BFS
2) 시작점에서 도착점으로 가는 BFS
총 2번 BFS를 수행합니다.


n(1 <= n <= 50) 행의 크기, m(1 <= m <= 50) 이기 때문에 
O(nm)은 O(2500) 문제의 시간 제한이 1초 이기 때문에 시간안에 풀 수 있습니다.

*/





