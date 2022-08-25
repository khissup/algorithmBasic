package day_0822.Recursive;

import java.util.Arrays;

// 5개중에 3개 뽑기 (조합)
public class Recursive06 {
    static int[] arr = {1, 3, 5, 7, 9};
    // 재귀 함수를 이용하여 arr의 모든 요소값의 합과 곱을 인자하나로 구하세요
    public static void main(String[] args) {
        recursive(arr, new int[3], 0, 0);
    }

    // k가 셀렉트 배열
    // 2개뽑겠다 하면, 셀렉트배열의 몇번째거에 채울지가 k변수

    //idx 변수

            //1, 3 5가 있는데 이걸 쳐다보고있는게 idx변수
    ////
    static int cnt = 0;
    // 3개를 다 뽑으면 빠져나가면됨
    private static void recursive(int[] arr, int[] sel, int idx, int k) {
        // basis part
        // 다 뽑았으면 빠져나감
        if(k == sel.length) {
            cnt++;
            System.out.println(Arrays.toString(sel));
            return;
        }
        // idx : 몇번째를 뽑을까요?.. 하는 변수임
        // 더이상 뽑을게 없어요
        if(idx == arr.length) {
            return;
        }
        // 뽑는 경우
        sel[k] = arr[idx];
        // sel[k] = idx;
        recursive(arr, sel, idx + 1, k + 1);

        // 안뽑는 경우
        recursive(arr, sel, idx + 1, k);
        // inductive part
//        sum += arr[idx];
//        recursive(idx + 1, sum);
//        recursive(idx + 1, val + arr[idx]);
//        recursive(idx + 1, val * arr[idx]);

    }
}
