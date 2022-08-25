package day_0822.Recursive;

import java.util.Arrays;

// 3개중에 3개 뽑기 ( 순서 있고, 중복있다 ) 중복순열
public class Recursive07_2 {
    static int[] arr = {1, 3, 5};

    // 재귀 함수를 이용하여 arr의 모든 요소값의 합과 곱을 인자하나로 구하세요
    public static void main(String[] args) {
        recursive(arr, new int[3], 0, 0);

    }


    static int cnt = 0;
    // 3개를 다 뽑으면 빠져나가면됨
    private static void recursive(int[] arr, int[] sel, int idx, int k) {
        // basis part
        // 다뽑았어요
        if(k == sel.length) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        sel[k] = arr[0];
        recursive(arr, sel, idx + 1, k + 1);

        sel[k] = arr[1];
        recursive(arr, sel, idx + 1, k + 1);

        sel[k] = arr[2];
        recursive(arr, sel, idx + 1, k + 1);
    }
}
