package printStar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test1954 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input1954.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            map[0][0] = 1;
            int direction = 0;
            int xPosition = 0;
            int yPosition = 0;
            int ny = 0; // 다음에 탐색할 y좌표
            int nx = 0; // 다음에 탐색할 x좌표
            int num = 2;
            int[] dy = new int[]{0, 1, 0, -1}; // 오른쪽 아래 위 왼쪽 순으로 탐색
            int[] dx = new int[]{1, 0, -1, 0};


            while(num <= N * N) {
                int k = direction;
                while (true) {
                    ny = yPosition + dy[k];
                    nx = xPosition + dx[k];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                        if(map[ny][nx] == 0) {
                            direction = k;
                            break;
                        }
                    }
                    if(k == 3) {
                        k = 0;
                    } else {
                        k++;
                    }
                }
                yPosition = ny;
                xPosition = nx;
                map[yPosition][xPosition] = num++;
            }
            sb.append("#");
            sb.append(test_case);
            sb.append("\n");
            for(int[] temp : map) {
                for(int data : temp) {
                    sb.append(data);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}
