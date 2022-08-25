package day_0822.Recursive;

import java.util.Arrays;

// 3개중에 3개 뽑기 ( 순서 있고, 중복허용안함 ) 순열
public class Recursive08 {
    static int[] arr = {1, 3, 5};

    // 재귀 함수를 이용하여 arr의 모든 요소값의 합과 곱을 인자하나로 구하세요
    public static void main(String[] args) {
        recursive(arr, new int[3], 0, 0,new boolean[arr.length]);
        System.out.println(cnt);
    }


    static int cnt = 0;
    // 3개를 다 뽑으면 빠져나가면됨
    private static void recursive(int[] arr, int[] sel, int idx, int k, boolean[] v) {
        // basis part
        // 다뽑았어요
        if(k == sel.length) {
            cnt++;
            System.out.println(Arrays.toString(sel));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!v[i]) {
                v[i] = true;
                sel[k] = i;
                recursive(arr, sel, idx + 1, k + 1, v);
                v[i] = false;
            }
        }
//        sel[k] = arr[0];
//        recursive(arr, sel, idx + 1, k + 1);
//
//        sel[k] = arr[1];
//        recursive(arr, sel, idx + 1, k + 1);
//
//        sel[k] = arr[2];
//        recursive(arr, sel, idx + 1, k + 1);
    }
}
