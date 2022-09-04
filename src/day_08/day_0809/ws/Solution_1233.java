package day_08.day_0809.ws;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1233 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input1233.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int countOperator = 0; // 연산자
            int countOperand = 0; // 피연산자(숫자)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int vertex = Integer.parseInt(st.nextToken());
                while(st.hasMoreTokens()) {
                    if("+-*/".contains(st.nextToken())) {
                        countOperator++;
                    } else {
                        countOperand++;
                    }
                }
            }
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            if(countOperand - countOperator == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
