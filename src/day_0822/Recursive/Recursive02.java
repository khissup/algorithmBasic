package day_0822.Recursive;

public class Recursive02 {
    // 1 ~ 5 더하기 (sum 함수의 인자로 넘기기)
    public static void main(String[] args) {
        recursive(0, 0);
    }
    public static void recursive(int i, int sum) {
        // basis part
        if(i == 6) {
            System.out.println(sum);
            return;
        }

        // inductive
        recursive(i + 1, sum + i);
    }

    // 스택인자 = 지역변수수
}
