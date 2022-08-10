package day_0810.ex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class Solution_1861_정사각형방2 { //0.46955s

    static int[][] Arr ;
    static int[] V;
    static int TC,N;

    static int[] dr = {-1,1,0,0} ; //상 하 좌 우
    static int[] dc = {0,0,-1,1} ; //상 하 좌 우
    static int max = 0;
    static int S = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input1861.txt"));
        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();
        for(int t=1;t<=TC;t++) {
            N = sc.nextInt();
            Arr = new int[N][N];
            V = new int[N*N+1];
            max = 0;


            for(int i=0;i<Arr.length;i++) {
                for(int j=0;j<Arr[i].length;j++) {
                    Arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<Arr.length;i++) {
                for(int j=0;j<Arr[i].length;j++) {
                    if(V[Arr[i][j]] == 0) dfs(i,j);
                    max = Math.max(V[Arr[i][j]], max);
                }
            }

            S=9999;
            for(int i=1;i<V.length;i++) {
                if(max == V[i]) {
                    S = i;
                    break;
                }
            }

            System.out.printf("#%d %d %d%n",t,S,max);
        }


    }

    private static int  dfs(int row, int col ) {
        if(V[ Arr[row][col]] >0) {
            return V[ Arr[row][col]];
        }


        for(int i=0;i<dr.length;i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr>=0 && nc >=0 && nr<N && nc < N &&  Arr[nr][nc] == Arr[row][col] + 1) {
                return   V[ Arr[row][col]] = dfs(nr,nc) + 1;
            }

        }

        V[ Arr[row][col]] = 1;
        return 1;

    }

}

