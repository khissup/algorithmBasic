package day_0804.ex;

import java.util.Arrays;

//주사위 던지기
public class Test01 {
    static int N=3;
    static int count=0;
    static int[] path= new int[N+1];
    static int[] used= new int[7];
    
	public static void main(String[] args) {
		f(1);
		System.out.println(count);
	}

	private static void f(int now) {
		if(now > N) {
			count++;
			System.out.println(Arrays.toString(path));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			if(used[i] == 1) continue;
			path[now] = i;
			used[i] = 1;
			
			f(now+1);
			
			path[now] = 0;
			used[i] =0;
			
		}
		
	}
}



