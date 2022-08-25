package day_0822.Recursive;

public class Recursive05 {
    static int[] arr = {1, 3, 5};
    // 재귀 함수를 이용하여 arr의 모든 요소값의 합과 곱을 인자하나로 구하세요
    public static void main(String[] args) {
        recursive(0, 1);
    }
    private static void recursive(int idx, int val) {
        // basis part
        if(idx == arr.length) {
            // 이게 2번이 찍힐것같은데 8번이 찍힘.. 대체왜그럴까?
            System.out.println(val);
            return;
        }

        // inductive part
//        sum += arr[idx];
//        recursive(idx + 1, sum);
        recursive(idx + 1, val + arr[idx]);
        recursive(idx + 1, val * arr[idx]);

    }
}
