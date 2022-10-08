package util;
import java.util.Scanner;

// n개의 수를 입력받고 가능한 모든 부분집합 생성
public class 부분집합 {

	static int N;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[] {-7,-3,-2,5,8};
		N = input.length;//
		
		isSelected = new boolean[N];
		
		
		
		subset(0, 5);
	}

	private static void subset(int now,int sum) { 
	
		if(now == N) {
			if(sum == 0) {
				for (int i = 0; i < N; i++) {
					System.out.print(isSelected[i]?input[i]:"X");
					//System.out.print(input[i]);
					System.out.print("\t");
				}
				System.out.println();//
			}
			return;
		}
		// 원소 선택
		isSelected[now] = true;//
		subset(now+1 , sum+input[now]);

		// 원소 미선택
		isSelected[now] = false;
		subset(now+1 , sum);
	}
	
	
	
	
	
}
