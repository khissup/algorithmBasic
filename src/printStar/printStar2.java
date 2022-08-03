package printStar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class printStar2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            for (int j = num - 1; j >= 0; j--) {
                sb.append(" ");
            }
        }
    }
}
