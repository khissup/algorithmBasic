package day_0811.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B3040 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] people = new int[9];
        int a = 0;
        int b = 0;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
            sum += people[i];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sum - (people[i] + people[j]) == 100) {
                    a = i;
                    b = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if(i != a && i != b) {
                sb.append(people[i]);
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
