package day_0808.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input1228.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> data = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                data.add(Integer.parseInt(st.nextToken()));
            }
            int makePwCount = Integer.parseInt(br.readLine());
            String[] makePwLogic = br.readLine().split("I ");
            for(int i = 1; i <= makePwCount; i++) {
                st = new StringTokenizer(makePwLogic[i], " ");
                int insertIndex = Integer.parseInt(st.nextToken());
                int insertCount = Integer.parseInt(st.nextToken());
                for(int j = 0; j < insertCount; j++) {
                    data.add(insertIndex, Integer.parseInt(st.nextToken()));
                    insertIndex++;
                }
            }
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(data.get(i));
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
