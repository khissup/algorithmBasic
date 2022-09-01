package util;

import java.util.Arrays;

public class asdf {
    static int[] arr = new int[2];
    public static void main(String[] args) {
        test(0, 0);
    }
    private static void test(int cnt, int start) {
        if(cnt == 2) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = start; i <= 10; i++) {
            if(cnt == 1 && i > 5) break;
            arr[cnt] = i;
            test(cnt + 1, start);
        }
    }
}
