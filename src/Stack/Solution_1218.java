package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
//0830

public class Solution_1218 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input1218.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++) {
            Map<Character, Character> logic = new HashMap<>();
            Map<Character, Integer> quantity = new HashMap<>();

            logic.put(')', '(');
            logic.put(']', '[');
            logic.put('}', '{');
            logic.put('>', '<');

            quantity.put('(', 0);
            quantity.put('[', 0);
            quantity.put('{', 0);
            quantity.put('<', 0);

            int result = 1;

            int length = Integer.parseInt(br.readLine());
            char[] words = br.readLine().toCharArray();
            for(int i = 0; i < length; i++) {
                if("([{<".contains(words[i] + "")) {
                    quantity.put(words[i], quantity.get(words[i]) + 1);
                } else if(")]}>".contains(words[i] + "")) {
                    if(quantity.get(logic.get(words[i])) > 0) {
                        quantity.put(logic.get(words[i]), quantity.get(logic.get(words[i])) - 1);
                    } else {
                        result = 0;
                        break;
                    }
                }
            }
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(result);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}