package day_0809.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1861 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] room = new int[N][N];
            int[][] logicRoom;
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};
            int[] maxMoveCount = new int[2];
            int[] currentMoveCount = new int[2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    logicRoom = room.clone();
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                            if(logicRoom[ny][nx] - logicRoom[i][j] == 1) {
                                currentMoveCount[0] = logicRoom[i][j];
                                currentMoveCount[1]++;
                                int temp = logicRoom[i][j];
                                logicRoom[i][j] = logicRoom[ny][nx];
                                logicRoom[ny][nx] = temp;
                                if(maxMoveCount[0] > currentMoveCount[0] && )
                            }
                        }
                    }
                }
            }


        }
    }

}
class Car {
    int yPos;
    int xPos;
    int moveCount;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public Car(int yPos, int xPos) {
        this.yPos = yPos;
        this.xPos = xPos;
    }
}

