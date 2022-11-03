package util;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author THKim
 */
public class 순열_조합 {

	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 던지는 주사위 수
		
		numbers = new int[N];
		
//		dice1(0);
//		isSelected = new boolean[7]; // 1~6 주사위눈 선택여부
//		dice2(0);
//		dice3(0, 1);
		dice4(0,1);
	}
	
	// 주사위던지기1 : 중복순열
	private static void dice1(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수 시도 ( 주사위 눈 1~6 )
		for (int i = 1; i <= 6; i++) {
			// 수의 중복선택이 가능하므로 중복체크 필요없음!
			// 해당 수 선택
			numbers[cnt] = i;
			// 다음 주사위던지러 가기
			dice1(cnt+1);
			//return;
			
			// numbers[0] = 1;
			// numbers[1] = 5;
			// numbers[2] = 
			
			// 111 222 333 444 555 666
			
		}
	}
	
	// 주사위던지기2 : 순열
	private static void dice2(int cnt) { //순열
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));

			return;
		}
		
		// 가능한 모든 수 시도 ( 주사위 눈 1~6 )
		for (int i = 1; i <= 6; i++) {
			// 중복체크 필요!
			if(isSelected[i]) continue;
			// 해당 수 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			// 다음 주사위던지러 가기
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	//
	// 주사위던지기3 : 중복조합
	private static void dice3(int cnt,int start) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	// 주사위던지기4 : 조합
	private static void dice4(int cnt,int start) {
		if(cnt == N) {
			System.out.print("");
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);//
		}
	}
}













