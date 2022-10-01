package util;

public class Subset_Practice {

    static int[] src = { 1, 2, 3, 4, 5 };
    static boolean[] select = new boolean[src.length];

    public static void main(String[] args) {
        subset(0);
    }

    private static void subset(int i) {
        if (i == src.length) {
            print();
            return;
        }

        select[i] = true; // 선택
        subset(i + 1); // 재귀
        select[i] = false; // 선택 X
        subset(i + 1); // 재귀//

    }

    private static void print() {
        for (int i = 0; i < select.length; i++) {
            if (select[i]) System.out.print(src[i] + " ");
        }
        System.out.println();
    }

}

/*

// you can also use imports, for example:
import java.lang.*;
import java.io.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    static int[] arr;
    static boolean[] select;
    public int solution(int[] A) {
        arr = A;
        select = new boolean[arr.length];
        subset(0);
        return 0;
    }
    private static void subset(int i) {
        if(i == arr.length) {
            getLength();
            return;
        }
        select[i] = true;
        subset(i + 1);
        select[i] = false;
        subset(i + 1);
    }
    private static void getLength() {
        int result = arr[0];
        int resultLength = 1;
        // 초기값이후 나머지를 더한 길이를 구하므로
        // 초기값은 1로 설정
        for(int i = 1; i < select.length; i++) {
            if(select[i]) {
                result = result & arr[i];
                resultLength++;
            }
        }
        System.out.println(result + " " + resultLength);
    }
}


 */