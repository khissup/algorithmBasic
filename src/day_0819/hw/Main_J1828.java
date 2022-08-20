package day_0819.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_J1828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // 최고온도 기준 오름차순 정렬
        // 근데 문제자체가 .. 굳이 왜 ?이렇게 해야하는지 이해가 좀 안감
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        int r = list.get(0)[1];
        for(int i = 1; i < N; i++) {
            if(r < list.get(i)[0]) {
                r = list.get(i)[1];
                result++;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
