package day_0822.Recursive;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

// 3개중 부분 집합모음 
public class Recursive10 {
	static int[] arr = { 1, 3, 5 };

	public static void main(String[] args) {

		recursive(arr, 0, 0, new boolean[arr.length]);
		System.out.println(cnt);
	}

	static int cnt = 0;

	private static void recursive(int[] arr, int idx, int k, boolean[] sel) {
		// basis part
		// 다뽑았어요
		if (idx == arr.length) {
			cnt++;
			//System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}

		sel[idx] = true;
		recursive(arr, idx+1,  k + 1, sel);
		sel[idx] = false;
		recursive(arr, idx+1,  k, sel);
	}
}
