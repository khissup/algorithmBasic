package day_08.day_0822.Recursive;

public class Recursive03 {
    static int[] arr = {1, 3, 5};
    // 재귀 함수를 이용하여 arr의 모든 요소값의 합을 구하세요
    public static void main(String[] args) {
        recursive(0, 0);
    }
    private static void recursive(int idx, int sum) {
        // basis part
        if(idx == arr.length) {
            System.out.println(sum);
            return;
        }

        // inductive part
//        sum += arr[idx];
//        recursive(idx + 1, sum);
        recursive(idx + 1, sum + arr[idx]);
    }
}
