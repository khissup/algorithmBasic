package day_0803.ws;

public class BigO {
	public static void main(String[] args) {
		// O(1)
		for(int i = 0; i < 10; i++) {
			
		}
		
		// O(N)
		int N = 100;
		for(int i = 0; i < N; i++) {
			
		}
		
		// O(N * 2) 10000
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
			}
		}
		
		// O(N) N의 크기를 반드시 들여다 봐야함.
		for(int i = 0; i < 1000000000; i++) {
			System.out.println(i);
		}
		
		/// O(N * 2)
		for(int i = 0; i < N; i++) {
			//f(N);
		}
	}
}

/*

시간복잡도

빅오표기법
O(1)
O(N)
O(N^2)
O(N^3)
O(N!)
O(NlogN)
O(logN)

O(logN) 1 ~ 1000000 => 반복 횟수 20회
log2^100000 => 대략 20

2^10 = 1024
2^20 = 100만
2^30 = 10억

10! = 360만
11! = 4000만
12! = 4억

N : 1000			DP(Dynamic Programming) 동적 계획법
N : 1000000			DP + 그리디(탐욕 알고리즘) 문제
N : 0 ~ 30			완전탐색문제
N : 100 ~ 200		BFS(너비 우선 탐색)문제 Breadth-First Search
*/