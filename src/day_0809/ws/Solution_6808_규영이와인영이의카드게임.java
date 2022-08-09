package day_0809.ws;

import java.io.FileInputStream;
import java.util.Scanner;

// 순열 문제
public class Solution_6808_규영이와인영이의카드게임 {
    static boolean[] number;
    static boolean[] selected;
    static int[] arr1 = new int[9]; // 규영이 카드
    static int[] arr2 = new int[9]; // 인영이 카드
    static int win, cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input6808.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC; t++) {
            win = 0;
            selected = new boolean[9];
            number = new boolean[19]; // 1 ~ 18. 0번째 인덱스는 쓰지 않음

            for (int i = 0; i < 9; i++) {
                arr1[i] = sc.nextInt();
                number[arr1[i]] = true;
            }
            int temp = 0;
            for (int i = 1; i < number.length; i++) {
                if(!number[i]) {
                    arr2[temp++] = i;
                }
            }
            f(0, 0, 0);
            // 0 번째부터 시작,
            // 규영, 인영의 합계는 0부터 시작
            System.out.printf("#%d %d %d \n", t, win, 362880 - win);
        }
    }

    // 순열
    private static void f(int r, int sum1, int sum2) {
        // r : 순열
        // sum1 : 규영이 점수
        // sum2 : 인영이 점수
        if(r == 9) {
            if(sum1 > sum2); // win++;
            return; // 종료 조건
        }
        
        // 선택지
        for(int i = 0; i < 9; i++) {
            if(!selected[i]) {
                selected[i] = true;

                // 규영이가 이긴 상황. 그러므로 규영이의 기존 합계점수에 규영이 + 인영이 점수 넣어줌
                if(arr1[r] > arr2[i]) {
                    f(r + 1, sum1 + arr1[r] + arr2[i], sum2);
                } else {
                    f(r + 1, sum1, sum2 + arr1[r] + arr2[i]);
                }
                selected[i] = false;
            } // 해당 수 선택

        }
    }

}
