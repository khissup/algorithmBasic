package day_08.day_0822.Recursive;

import java.util.Arrays;

// 3개중에 3개 뽑기 (순서없 중복없다) 조합
public class Recursive09 {
    static int[] arr = {1, 3, 5};

    public static void main(String[] args) {
        recursive(arr, new int[3], 0, 0, new boolean[arr.length]);
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

        for (int i = idx; i < arr.length; i++) {
            sel[k] = i;
            recursive(arr, sel, i + 1, k + 1, v);
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
