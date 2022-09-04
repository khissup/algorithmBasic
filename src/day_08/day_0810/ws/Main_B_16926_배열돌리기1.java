package day_08.day_0810.ws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/16926

public class Main_B_16926_배열돌리기1 {
    static int R, C,CNT;
    static int[][] Arr ;
    
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/16926.txt"));
		Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        CNT = sc.nextInt();
        
        Arr = new int[R][C];
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		Arr[i][j] = sc.nextInt();
        	}
        }
        
        int g = Math.min(R, C) / 2;
       
        for(int i=0;i<CNT;i++) { 
        	//그룹 갯수
            for(int j=0;j<g;j++) {
            	        //rs, re, cs, ce
            	leftRotate(j,R-1-j,j,C-1-j);//0,0  3,3
            	                            //1,1  2,2
            }

        }
             
         StringBuilder sb = new StringBuilder();
	      for(int i=0;i<R;i++) {
	      	for(int j=0;j<C;j++) {
	      		sb.append(Arr[i][j]+" ");
	      	}
	      	sb.append("\n");
	      }
	      System.out.println(sb.toString());
                
    }
	
	//좌 상 우 하   (데이터이동방향)
	static void leftRotate(int rs, int re, int cs, int ce) {
		int temp = Arr[rs][cs];
		for(int i=cs; i<ce; i++) Arr[rs][i] = Arr[rs][i+1];
		for(int i=rs; i<re; i++) Arr[i][ce] = Arr[i+1][ce]; 
		for(int i=ce; i>cs; i--) Arr[re][i] = Arr[re][i-1];
		for(int i=re; i>rs; i--) Arr[i][cs] = Arr[i-1][cs];
		Arr[rs+1][cs] = temp;
	}
		
		
	//상  좌   하  우(데이터이동방향)
	static void rightRotate(int rs, int re, int cs, int ce) {
		int temp = Arr[rs][cs];
		for(int i=rs; i<re; i++) Arr[i][cs] = Arr[i+1][cs]; 
		for(int i=cs; i<ce; i++) Arr[re][i] = Arr[re][i+1];
		for(int i=re; i>rs; i--) Arr[i][ce] = Arr[i-1][ce];
		for(int i=ce; i>cs; i--) Arr[rs][i] = Arr[rs][i-1];
		Arr[rs][cs+1] = temp;
	}
	
}

/*

int[] dr = { 0, 1, 0, -1 };
int[] dc = { 1, 0, -1, 0 }; 
	 우 하 좌 상 (위치이동 방향 , 시계방향)

*/

