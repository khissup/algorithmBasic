package day_0809_dfs.ws;

import java.io.FileInputStream;
import java.util.Scanner;


public class Solution_1861_정사각형방 { //0.46955s

    static int[][] Arr ;
    static int TC,N;

    static int[] dr = {-1,1,0,0} ; //상 하 좌 우
    static int[] dc = {0,0,-1,1} ; //상 하 좌 우
    static int max = 0;
    static int S = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input/1861.txt"));
        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();
        for(int t=1;t<=TC;t++) {
            N = sc.nextInt();
            Arr = new int[N][N];
            max = 0;
            S=9999;


            for(int i=0;i<Arr.length;i++) {
                for(int j=0;j<Arr[i].length;j++) {
                    Arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<Arr.length;i++) {
                for(int j=0;j<Arr[i].length;j++) {
                    dfs(i,j,Arr[i][j],1);
                }
            }


            System.out.printf("#%d %d %d%n",t,S,max);
        }


    }

    private static void dfs(int row, int col , int start,int cnt) {

        if(max < cnt) {
            max = cnt;
            S=start;
        }else if(max == cnt){
            if(S > start) S=start;
        }

        for(int i=0;i<dr.length;i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr>=0 && nc >=0 && nr<N && nc < N &&  Arr[nr][nc] == Arr[row][col] + 1) {
                dfs(nr,nc,start,cnt+1);
            }

        }
    }

}

