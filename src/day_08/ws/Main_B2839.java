package day_08.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append(cal(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();//
    }
    private static int cal(int num) {
        int result = Integer.MAX_VALUE;
        int i = 0;
        int j;
        while(i * 3 <= num) {
            j = 0;
            while(j * 5 <= num) {
                if(i * 3 + j * 5 == num && i + j < result) {
                    result = i + j;
                }
                j++;
            }
            i++;
        }
        if(result == Integer.MAX_VALUE)
            result = -1;
        return result;
    }
}
