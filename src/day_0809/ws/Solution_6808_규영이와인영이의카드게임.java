package day_0809_dfs.ws;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class Solution_6808_규영이와인영이의카드게임 {

    static boolean[] number;
    static boolean[] selected;
    static int[] Arr1 = new int[9]; // 규영이 카드
    static int[] Arr2 = new int[9]; // 인영이 카드
    static int win,cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input6808.txt"));
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for(int t=1; t<=TC; t++) {
            win = 0;
            selected = new boolean[9];
            number = new boolean[19]; // 1 ~ 18. 0번째 인덱스는 쓰지 않음

            for(int i=0;i<9;i++) {
                Arr1[i] = sc.nextInt();
                number[Arr1[i]] = true;
            }
            int tmp = 0;
            for(int i=1;i<number.length;i++) {
                if(!number[i])
                    Arr2[tmp++] = i;
            }

            f(0,0,0);
            // 0 번째부터 시작,
            // 규영, 인영의 합계는 0부터 시작

            System.out.printf("#%d %d %d%n",t,win,(362880-win));
        }
    }

    private static void f(int r , int sum1 , int sum2) { //순열
        // r : 순열
        // sum1 : 규영이 점수
        // sum2 : 인영이 점수
        if(r == 9) {
            if(sum1 > sum2) win++;
            return;
        }

        // 선택지
        for (int i = 0; i < 9; i++) {
            if(!selected[i]) {
                selected[i] = true;

                // 규영이가 이긴 상황. 그러므로 규영이의 기존 합계점수에 규영이 + 인영이 점수 넣어줌
                if(Arr1[r] > Arr2[i]) {
                    f(r+1,sum1+Arr1[r]+Arr2[i],sum2);
                }else {
                    f(r+1,sum1,sum2+Arr1[r]+Arr2[i]);
                }

                selected[i] = false;
            } // 해당 수 선택
        }
    }


}
/*
 *
#1 112097 250783
#2 250783 112097
#3 336560 26320
#4 346656 16224	//첫 번째 테스트케이스 결과
//두 번째 테스트케이스 결과

 */
