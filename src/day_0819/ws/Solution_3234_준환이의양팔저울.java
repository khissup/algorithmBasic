package day_0819.ws;

import java.io.IOException;
import java.util.Scanner;

//swexpertacademy 문제 => 3234  준환이의 양팔저울

public class Solution_3234_준환이의양팔저울 {
   static int res;
      
   public static void main(String[] args) throws IOException {

      Scanner sc = new Scanner(System.in);
      
      int T = sc.nextInt();
      for (int tc = 1; tc <= T; tc++) {
         res = 0;
         int N = sc.nextInt();
         int[] arr = new int[N];
       
         for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
         }
         
         
         f(0,arr,N,new boolean[N],0,0);
         
         System.out.println("#" + tc + " " + res);
      }
 
   }
   private static void f(int idx,int[] arr,int N,boolean[] used,int left,int rigth) { //순열
		if(idx == N) {
			res++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			used[i] = true;
			
			f(idx+1,arr,N,used,left+arr[i],rigth);

			if(left >= rigth+arr[i]) f(idx+1,arr,N,used,left,rigth+arr[i]);
			
			used[i] = false;
		}
	}
   
}

/*
1
3
1 2 4


3
1 2 3
9
1 2 3 5 6 4 7 8 9

*/
