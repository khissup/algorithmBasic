package day_08.day_0804.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1225.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); 

		StringBuilder sb = new StringBuilder(); 
		for (int t = 1; t<=10; t++) {
			int N = Integer.parseInt(sc.readLine());
//			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> queue = new ArrayDeque<Integer>();
			

			StringTokenizer st = new StringTokenizer(sc.readLine()," ");
			for(int i=0;i<8;i++) {     // 8개의 숫자를 입력 받는다.
				queue.add(Integer.parseInt(st.nextToken()));
			}
            
			boolean flag = false;
		    while(!flag) {
				for(int i=1;i<=5;i++) {  //1사이클
					
					int temp = queue.poll()-i ; //감소후 뒤로 이동 
					temp = temp<=0 ? 0 : temp;
					queue.add(temp);
					
					if(temp ==0) {
						flag = true;
						break;
					}
				}
		    }
		   
		    sb.append("#"+t+" ");
		    for(int data : queue) {
		    	sb.append(data).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void f(){
		
	}
}
