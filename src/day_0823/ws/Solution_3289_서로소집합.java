package day_0823.ws;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * -서로소집합-
 * 상호배타 집합-트리 로 구현
 * 연산횟수가 크니 StringBuilder로 출력 ??
 */

//출처 : https://swexpertacademy.com/
public class Solution_3289_서로소집합 {
	
	static int[] parents;
	static int TC,N,M;
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/3289.txt"));
		Scanner sc =new Scanner(System.in);
		TC = sc.nextInt();
		for(int t=1;t<=TC;t++) {
			StringBuilder sb = new StringBuilder();
			N = sc.nextInt();  //원소수
			M = sc.nextInt();  //연산수
			parents = new int[N+1];
			makeSet();
			for(int i=0;i<M;i++) {
				switch (sc.nextInt()) {
					case 0:
					   union(sc.nextInt(),sc.nextInt());
					break;

					case 1:
					   int a= find(sc.nextInt());	
					   int b= find(sc.nextInt());
					   sb.append(a==b?1:0);
					break;	
				}
			}
			System.out.printf("#%d %s%n",t,sb.toString());
		}
	}
	
	static void makeSet() {
        for (int i = 0; i <= N; i++) {
			parents[i] = i;       //자신이 부모 어떤정점 과도 연결 되지 않은 상태로 초기화 
		}
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);   //자기 자신을 가리키는 최상위 부모까지 찾아간다.
              //path 압축 효과 기대 
    }

    static boolean union(int a, int b){  //a와 b를 연결하기 위해 가가각의 부모를 찾는다.
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {  //두정점의 부모가 서로 다르면 연결 
            parents[bRoot] = aRoot;
            return true;
        }
        return false;  
    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

         
①     ②   
   ③      ④  
       ⑤       
 ⑦    ⑥ 

*/
