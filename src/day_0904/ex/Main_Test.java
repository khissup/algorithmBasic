package day_0904.ex;

import java.util.Arrays;

public class Main_Test {
    static int N;
    static int[] numbers;
    static boolean[] isSelected;
    public static void main(String[] args) {
        numbers = new int[2];
        dice4(0, 1);
    }
    private static void dice4(int cnt, int start) {
        if(cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);
        }
    }
}
